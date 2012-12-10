#!/usr/bin/env python 
"""

"""
from nxt.locator import *
from nxt.sensor import *
from nxt.motor import *
from time import *
import numpy as npy
import cv2

#Parameters
SPEED_MAIN =60
tend= 5 #this is how long the robot will drive between bouts
WARNING_C= -10
THRESH_ERROR = 10

#ray tracing
THRESH = 5 #this is a threshold value so it does not interpret the goal as an obstacle
THRESH_GOAL= 10 #this is the threshold to interperet at the goal
GOAL_X =0
GOAL_Y =0
win = False
warning = 0


oldspeed = npy.zeros(2) +SPEED_MAIN
oldError = npy.zeros(2)
#Weights of orientation, ray and distance
O = 2
R = 2
D = 1

#array numerators E being far left and D being far right
E=0
C=1
A=2
B=3
D=4

#weights
e=d=0.1
c=b=0.2
a=0.4

#vision
cam = None

hsv = None

colourGrabWindowSize = 5

rightButtonX = 0
rightButtonY = 0
leftButtonX = 0
leftButtonY = 0

blueHue = 0
blueHueWindowSize = 40
blueSaturation = 0
blueSaturationWindowSize = 40
blueValue = 0
blueValueWindowSize = 40

redHue = 0
redHueWindowSize = 30
redSaturation = 0
redSaturationWindowSize = 30
redValue = 0
redValueWindowSize = 30

goalHue = 0
goalHueWindowSize = 40
goalSaturation = 0
goalSaturationWindowSize = 40
goalValue = 0
goalValueWindowSize = 40


groundHue = 0
groundHueWindowSize = 40
groundSaturation = 0
groundSaturationWindowSize = 40
groundValue = 0
groundValueWindowSize = 40



def RayTrace(x0, y0, xg, yg):
    x = x0;
    y= y0;
    RESOLUTION = 1.0
    chx = (xg-x0)/RESOLUTION
    chy = (yg-y0)/RESOLUTION
    while(x< xg-THRESH and y < yg-THRESH):
        x+=chx
        y+=chy
        if(CheckPixel(x,y)): #this is a function that returns T/F if pixel is not goal
            len = x*x + y*y
            return len
    return -1

def GetRays():
        ori[2] = GetRobot()   #alex Function
        g[2] = [(GOAL_X, GOAL_Y)]

        output[A] =  RayTrace(ori[0], ori[1], g[0], g[2])#main ray direct from robot
        
        vec[2] = {0,0}
        vec = g - ori
        dist = sqrt(vec[0]*vec[0] + vec[1]*vec[1]) #distance between points
        vec /= dist   #direction to goal
        #the vector is now normalised
        
        newG = (ME *vec * dist) + ori #rotate vector by 2theta
        output[E] = RayTrace(ori[0],ori[1], newG[0], newG[1])
        
        newG = (MC *vec * dist) + ori #rotate vector by theta
        output[E] = RayTrace(ori[0],ori[1], newG[0], newG[1])
        
        newG = (MB *vec * dist) + ori #rotate vector by -theta
        output[B] = RayTrace(ori[0],ori[1], newG[0], newG[1])
        
        newG = (MD *vec * dist) + ori #rotate vector by -2theta
        output[D] = RayTrace(ori[0],ori[1], newG[0], newG[1])


def init():
    cs1 = cos(THETA)
    cs2 = cos(2*THETA)
    s1 = sin(THETA)
    s2 = sin(2*THETA)
    MC = [[cs1, -s1], [s1,cs1]]
    ME = [[cs2, -s2], [s2,cs2]]
    MB = [[cs1, s1], [-s1,cs1]]
    MD = [[cs2, s2], [-s2,cs2]]
    #these are the rotaion matricies for the ray tracing
    
    GOAL_X = ROBOT_GOAL_X() #alex function
    GOAL_Y = ROBOT_GOALY_() #alex function


#this gets the robot to turn and face the goal
def GetOrient():
    output = npy.zeros(5)
    alpha = GetAngle() #this is the angle between front of robot and back and the goal to back
    beta = 360-alpha
    if(alpha < beta):
            #turn left
            output[E] = output[C] =output[A] = alpha
            output[B] = output[D] =alpha
    else:
            output[E] = output[C] = -beta
            output[B] = output[D] =output[A] =beta
    return output    


#check sensors
def CheckSense():
    if(LightChange()):#warrens light sensor
        return true
    elif(TouchChange()):#warrens touch sensor
        return true
    return false
    
def get_robot():
    x = npy.mean(blueX, redX)
    y = npy.mean(blueY, redY)
    return npy.array([x, y])


def AtGoal():
    
    ori = npy.zeros(2)
    ori = GetRobot()   #alex Function
    if(ori[0] < GOAL_X + THRESH_GOAL and ori[0] > GOAL_X - THRESH_GOAL ):
        if(ori[1] < GOAL_Y + THRESH_GOAL and ori[1] > GOAL_Y - THRESH_GOAL ):
            return True
    return False


def Navigation():

    speed = npy.zeros(2)
    if(AtGoal()):
        print "Win"
        speed[0]=speed[1] = 0
        win = True
    else:
        if(CheckSense()): #this will cause the robot to back away
            print "Warning!"
            speed[0]=speed[1] = -SPEED_MAIN
            warning = WARNING_C
            return speed

        ori = getOrientError()    
        ray = GetRays()#this is warrens code
        dis = GetDist()
    
        for i in range(5):
            fin[i] = ori[i] *O + ray[i] *R + dis[i]*D
    
        SL = fin[0]*e + fin[1]*c
        SR = fin[3]*b + fin[4]*d
    
        if(SL > SR):#the worse error is on the left
            SL += fin[2]*a
        else:
            SR += fin[2]*a
    
        if(abs(SL) > THRESH_ERROR or abs(SR) > THRESH_ERROR):#if large error
            error = [SL, SR]
            oldspeed = speed  
            speed =K*oldspeed + L*(error - olderror) + M(error + olderror)
        else:
            speed[0]=speed[1] = SPEED_MAIN #if little error reset speed
    
    return speed

def Drive():
    b = find_one_brick() #initialization
    m_left = Motor(b, PORT_C) #set motors
    m_right = Motor(b, PORT_B)
    speed= npy.zeros(2)
    
    while(win ==False):
        if(warning < 0):
            warning += 1
        else:
            #do camera stuff
            speed = Navigation()
        m_left.run(speed[0])
        m_right.run(speed[1])
        start = time()# set start time
    
        while time()-start<tend: #wait for period of time
            continue 
        m_left.run(0)
        m_right.run(0)

def mouseCallBack(event, x, y, something, image):
    global rightButtonX
    global rightButtonY
    global leftButtonX
    global leftButtonY

    if (event == 2):
        rightButtonX = x
        rightButtonY = y
    elif (event == 1):
       leftButtonX = x
       leftButtonY = y

def get_orientation():
    ''' Assumes Blue Ball is at back of bot '''
    global blueX, blueY, redX, redY
    return calc_angle(blueX, blueY, redX, redY)
    
def get_angle_to_goal():
    global blueX, blueY, redX, redY
    global GOAL_X, GOAL_Y
    a = get_orientation()
    b = calc_angle(blueX, blueY, GOAL_X, GOAL_Y)
    return b - a




def calc_angle(ax, ay, bx, by):
    """Calculate the angel from A to B wrt origin """
    dx= bx - ax
    dy= by - ay
    return npy.arctan2(dy, dx)

def colour_picker(colourSTR ="(unspecified)", colourGrabWindowSize = 5, colourHueWindowSize = 40, colourSaturationWindowSize= 40, colourValueWindowSize =40):
    global cam
    global hsv

    print "Right click the ",colourSTR," blob. Hit escape when done."
    cv2.namedWindow("image") 
    cv2.setMouseCallback("image", mouseCallBack, param=None)
    try:
        while True:
            #Get image from webcam and convert to greyscale
            ret, img = cam.read()
            hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
            
            
            cv2.imshow("image", img)        
            
            cMinY = max(0, rightButtonY - colourGrabWindowSize)
            cMaxY = min(len(hsv) - 1, rightButtonY + colourGrabWindowSize)
            cMinX = max(0, rightButtonX - colourGrabWindowSize)
            cMaxX = min(len(hsv[0]) - 1, rightButtonX + colourGrabWindowSize)          
            
            cHue = int(npy.mean(hsv[redMinY:redMaxY, redMinX:redMaxX, 0]))
                        
            
            cSaturation = int(npy.mean(hsv[redMinY:redMaxY, redMinX:redMaxX, 1]))
            cValue = int(npy.mean(hsv[redMinY:redMaxY, redMinX:redMaxX, 2]))
            
            #Sleep infinite loop for ~10ms
            #Exit if user presses <Esc>
            if cv2.waitKey(10) == 27:
                break
    
    finally:
        cv2.destroyWindow("image")
        return np.array(cHue, cSaturation, cValue)

def set_colours():
    global cam 
    global hsv

    global colourGrabWindowSize
    global rightButtonX, rightButtonY
    global leftButtonX, leftButtonY
    global blueHue, blueHueWindowSize, blueSaturation, blueSaturationWindowSize, blueValue,blueValueWindowSize
    global redHue,redHueWindowSize,redSaturation,redSaturationWindowSize,redValue,redValueWindowSize
    global groundHue,groundHueWindowSize,groundSaturation,groundSaturationWindowSize,groundValue,groundValueWindowSize    
    global goalHue,goalHueWindowSize,goalSaturation,goalSaturationWindowSize,goalValue,goalValueWindowSize    
    

    print("Right click the red blob, left click the blue. Hit escape once done.")
    cv2.namedWindow("image") 
    cv2.setMouseCallback("image", mouseCallBack, param=None)
    try:
        while True:
            #Get image from webcam and convert to greyscale
            ret, img = cam.read()
            hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
            
            
            cv2.imshow("image", img)        
            
            blueMinY = max(0, leftButtonY - colourGrabWindowSize)
            blueMaxY = min(len(hsv) - 1, leftButtonY + colourGrabWindowSize)
            blueMinX = max(0, leftButtonX - colourGrabWindowSize)
            blueMaxX = min(len(hsv[0]) - 1, leftButtonX + colourGrabWindowSize)    
            
            blueHue = int(npy.mean(hsv[blueMinY:blueMaxY, blueMinX:blueMaxX, 0]))
            blueSaturation = int(npy.mean(hsv[blueMinY:blueMaxY, blueMinX:blueMaxX, 1]))
            blueValue = int(npy.mean(hsv[blueMinY:blueMaxY, blueMinX:blueMaxX, 2]))
            
                        
            
            redMinY = max(0, rightButtonY - colourGrabWindowSize)
            redMaxY = min(len(hsv) - 1, rightButtonY + colourGrabWindowSize)
            redMinX = max(0, rightButtonX - colourGrabWindowSize)
            redMaxX = min(len(hsv[0]) - 1, rightButtonX + colourGrabWindowSize)          
            
            redHue = int(npy.mean(hsv[redMinY:redMaxY, redMinX:redMaxX, 0]))
                        
            
            redSaturation = int(npy.mean(hsv[redMinY:redMaxY, redMinX:redMaxX, 1]))
            redValue = int(npy.mean(hsv[redMinY:redMaxY, redMinX:redMaxX, 2]))
            
            #Sleep infinite loop for ~10ms
            #Exit if user presses <Esc>
            if cv2.waitKey(10) == 27:
                break
    
    finally:
        cv2.destroyWindow("image")
    
    print("Right click the ground, Left click the goal. Hit escape once done.")
    cv2.namedWindow("image") 
    cv2.setMouseCallback("image", mouseCallBack, param=None)
    try:
        while True:
            #Get image from webcam and convert to greyscale
            ret, img = cam.read()
            hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
            
            
            cv2.imshow("image", img)        
            
            groundMinY = max(0, rightButtonY - colourGrabWindowSize)
            groundMaxY = min(len(hsv) - 1, rightButtonY + colourGrabWindowSize)
            groundMinX = max(0, rightButtonX - colourGrabWindowSize)
            groundMaxX = min(len(hsv[0]) - 1, rightButtonX + colourGrabWindowSize)          
            
            groundHue = int(npy.mean(hsv[groundMinY:groundMaxY, groundMinX:groundMaxX, 0]))
            groundSaturation = int(npy.mean(hsv[groundMinY:groundMaxY, groundMinX:groundMaxX, 1]))
            groundValue = int(npy.mean(hsv[groundMinY:groundMaxY, groundMinX:groundMaxX, 2]))
            
            goalMinY = max(0, leftButtonY - colourGrabWindowSize)
            goalMaxY = min(len(hsv) - 1, leftButtonY + colourGrabWindowSize)
            goalMinX = max(0, leftButtonX - colourGrabWindowSize)
            goalMaxX = min(len(hsv[0]) - 1, leftButtonX + colourGrabWindowSize)          
            
            goalHue = int(npy.mean(hsv[goalMinY:goalMaxY, goalMinX:goalMaxX, 0]))
            goalSaturation = int(npy.mean(hsv[goalMinY:goalMaxY, goalMinX:goalMaxX, 1]))
            goalValue = int(npy.mean(hsv[goalMinY:goalMaxY, goalMinX:goalMaxX, 2]))
            

            #Sleep infinite loop for ~10ms
            #Exit if user presses <Esc>
            if cv2.waitKey(10) == 27:
                break        
            
    finally:
        cv2.destroyWindow("image")

def show_vision(_n_=5):
    global blueX, blueY, redX, redY, GOAL_X, GOAL_Y
    global cv2
    #cv2.namedWindow("image") 
    #cv2.namedWindow("colour blob Blue")
    #cv2.namedWindow("colour blob Red")
    #cv2.namedWindow("ground")
    try:
        for _i_ in range(_n_):
            #Get image from webcam and convert to greyscale
            ret, img = cam.read()
            imgOriginal = img.copy()
            hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
            
            for i in range(0, 2):
                img = cv2.GaussianBlur(img, (5, 5), 0.0)
                   
            hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
    
            # Creates the thresholded image for the blue ball's colour        
            minHue = (blueHue - blueHueWindowSize) % 255
            minSaturation = max(blueSaturation - blueSaturationWindowSize, 0)
            minValue = max(blueValue - blueValueWindowSize, 0)
        
            maxHue = (blueHue + blueHueWindowSize) % 255
            maxSaturation = min(blueSaturation + blueSaturationWindowSize, 255)
            maxValue = min(blueValue + blueValueWindowSize, 255)    
            
            if minHue > maxHue:
                lower = cv2.inRange(hsv, npy.array([0, minSaturation, minValue]), npy.array([maxHue, maxSaturation, maxValue]))            
                upper = cv2.inRange(hsv, npy.array([minHue, minSaturation, minValue]), npy.array([255, maxSaturation, maxValue]))
                blueBall = cv2.add(upper,lower)
            else: 
                blueBall = cv2.inRange(hsv, npy.array([minHue, minSaturation, minValue]), npy.array([maxHue, maxSaturation, maxValue]))
            blueBall = blueBall.copy()
            
    
            # Creates the thresholded image for the red ball's colour
            minHue = (redHue - redHueWindowSize) % 255
            minSaturation = max(redSaturation - redSaturationWindowSize, 0)
            minValue = max(redValue - redValueWindowSize, 0)
        
            maxHue = (redHue + redHueWindowSize) % 255
            
            maxSaturation = min(redSaturation + redSaturationWindowSize, 255)
            maxValue = min(redValue + redValueWindowSize, 255)             
            
            if minHue > maxHue:
                lower = cv2.inRange(hsv, npy.array([0, minSaturation, minValue]), npy.array([maxHue, maxSaturation, maxValue]))            
                upper = cv2.inRange(hsv, npy.array([minHue, minSaturation, minValue]), npy.array([255, maxSaturation, maxValue]))
                redBall = cv2.add(upper,lower)
            else: 
                redBall = cv2.inRange(hsv, npy.array([minHue, minSaturation, minValue]), npy.array([maxHue, maxSaturation, maxValue]))       
            redBall = redBall.copy()            
            
            
            # Creates the thresholded image for the red ball's colour
            minHue = (goalHue - goalHueWindowSize) % 255
            minSaturation = max(goalSaturation - goalSaturationWindowSize, 0)
            minValue = max(goalValue - goalValueWindowSize, 0)
        
            maxHue = (goalHue + goalHueWindowSize) % 255
            
            maxSaturation = min(goalSaturation + goalSaturationWindowSize, 255)
            maxValue = min(goalValue + goalValueWindowSize, 255)             
            
            if minHue > maxHue:
                lower = cv2.inRange(hsv, npy.array([0, minSaturation, minValue]), npy.array([maxHue, maxSaturation, maxValue]))            
                upper = cv2.inRange(hsv, npy.array([minHue, minSaturation, minValue]), npy.array([255, maxSaturation, maxValue]))
                goal = cv2.add(upper,lower)
            else: 
                goal = cv2.inRange(hsv, npy.array([minHue, minSaturation, minValue]), npy.array([maxHue, maxSaturation, maxValue]))       
            goal = goal.copy()  

            # Creates the thresholded image for the ground's colour
            
          #  for i in range(0, 5):
          #      img = cv2.GaussianBlur(img, (11, 11), 0.0)
                
            minHue = (groundHue - groundHueWindowSize) % 255
            minSaturation = max(groundSaturation - groundSaturationWindowSize, 0)
            minValue = max(groundValue - groundValueWindowSize, 0)
        
            maxHue = (groundHue + groundHueWindowSize) % 255
            maxSaturation = min(groundSaturation + groundSaturationWindowSize, 255)
            maxValue = min(groundValue + groundValueWindowSize, 255)             
    
            ground = None
            if maxHue < minHue:
                groundOne = cv2.inRange(hsv, npy.array([maxHue, minSaturation, minValue]), npy.array([255, maxSaturation, maxValue]))       
                groundTwo = cv2.inRange(hsv, npy.array([0, minSaturation, minValue]), npy.array([minHue, maxSaturation, maxValue]))       
                ground = cv2.add(groundOne, groundTwo)
            else:
                ground = cv2.inRange(hsv, npy.array([minHue, minSaturation, minValue]), npy.array([maxHue, maxSaturation, maxValue]))       
                
            ground = ground.copy()         
            
            count = 1
            blueAvgX = 0
            blueAvgY = 0
            for y, x in npy.argwhere(blueBall > 128):
                blueAvgX += x 
                blueAvgY += y
                count += 1
            blueAvgX /= count
            blueAvgY /= count

            blueX = blueAvgX
            blueY = blueAvgY     
            
            count = 1
            redAvgX = 0
            redAvgY = 0
            for y, x in npy.argwhere(redBall > 128):
                redAvgX += x 
                redAvgY += y
                count += 1
            redAvgX /= count
            redAvgY /= count
            
            redX = redAvgX
            redY = redAvgY
            
            count = 1
            goalAvgX = 0
            goalAvgY = 0
            for y, x in npy.argwhere(goal > 128):
                goalAvgX += x 
                goalAvgY += y
                count += 1
            goalAvgX /= count
            goalAvgY /= count
            
            GOAL_X = goalAvgX
            GOAL_Y = goalAvgY
            


            ori = get_orientation()
            print ori/npy.pi*180            
            
            imgOriginal[blueAvgY - 3:blueAvgY + 3, blueAvgX - 3:blueAvgX + 3, :] = [0, 0, 255]        
            imgOriginal[redAvgY - 3:redAvgY + 3, redAvgX - 3:redAvgX + 3, :] = [255, 0, 0]        
            imgOriginal[goalAvgY - 3:goalAvgY + 3, goalAvgX - 3:goalAvgX + 3, :] = [255, 255, 0]

            cv2.imshow("image", imgOriginal)
            cv2.imshow("colour blob Blue", blueBall)
            cv2.imshow("colour blob Red", redBall)    
            cv2.imshow("ground", ground)  
            cv2.imshow("goal", goal)  
            
            #Sleep infinite loop for ~10ms
            #Exit if user presses <Esc>
            if cv2.waitKey(10) == 27:
                break
    finally:
        print "done"
        #cv2.destroyWindow("image")
        #cv2.destroyWindow("colour blob Blue")
        #cv2.destroyWindow("colour blob Red")
        #cv2.destroyWindow("ground")


def main():
    return True
        
if __name__ == '__main__':
    #print AtGoal()
    
    global redX, redY, blueX, blueY, GOAL_X, GOAL_Y
    cam = cv2.VideoCapture(0)
    
    set_colours()

    cv2.namedWindow("image") 
    cv2.namedWindow("colour blob Blue")
    cv2.namedWindow("colour blob Red")
    cv2.namedWindow("ground")
    cv2.namedWindow("goal")

    show_vision(1000)
    
    cv2.destroyWindow("image")
    cv2.destroyWindow("colour blob Blue")
    cv2.destroyWindow("colour blob Red")
    cv2.destroyWindow("ground")
    cv2.destroyWindow("goal")

    print "\tred: (",redX,",",redY,")\n\tblue: (",blueX,",",blueY,")"
    print "\tGOAL: (",GOAL_X,",",GOAL_Y,")"
    
    exit()
   
            
