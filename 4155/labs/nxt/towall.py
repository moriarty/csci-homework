"""
Created on Tue Sep 18 17:13:52 2012
@author: moriarty
"""

## Desired Distance
DIST = 25
TIME_LIMIT = 45
TURN_TIME = 2
START_POWER = 70
_KP = 0.25 #0.5
_KI = 0.001   #1
_KD = 1.0

import math as mth
from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *
from pylab import *

np.set_printoptions(precision=1)
b = find_one_brick()
t = Touch(b, PORT_2)
u = Ultrasonic(b, PORT_4)
m_right = Motor(b, PORT_B)
m_left = Motor(b, PORT_C)
m_left.brake()
m_right.brake()
_SPEED = 80

def to_wall(TIME_LIMIT):
    start = time()

    # Parameters
    N, P, gamma = 32, 0.8, .9
    n = 8

    # Reward function
    r = zeros(N) - 1; r[0] = 10;  r[N-1] = -10

    # Initiality random start policy and value function
    policy = floor(2*rand(N)); policy[0] = 2; policy[N-1] = 2
    Vpi = rand(N); Vpi[0]=r[0]; Vpi[N-1]=r[N-1]
    print policy
    print Vpi
    print '#################################'
    iter = 0
    while time() - start < TIME_LIMIT:
        iter = iter + 1
        u_val = u.get_sample()
        s = u_val/n
        print 'in state: ',s,' on iter ',iter,' policy=',policy[s]
        if t.is_pressed():
            r[s] = -100
            #policy[s] = 2
        if policy[s] == 2:
            return

        snext = s-1+2*policy[s]
        sother = s+1-2*policy[s]
        Vpi[s] = r[s]+gamma*(P*Vpi[snext]+(1-P)*Vpi[sother])
        
        #if policy[s] is not argmax([Vpi[s-1],Vpi[s+1]]):
        #    print 'updating policy from Vpi' 
        #    policy[s]=argmax([Vpi[s-1],Vpi[s+1]])

        pm = True
        if rand() < P:
            exc_action(policy[s])
        else:
            pm = False
            #print "not policy move"
            if policy[s]:
                exc_action(0)
            else:
                exc_action(1)
        while s == u.get_sample()/n and s is not 0:
            sleep(0.1)
            # wait for state to change
        stop_all()
        if pm and (u_val < u.get_sample()):
            #print "move was bad, modifying policy"
            if policy[s]:
                policy[s] = 0
            else:
                policy[s] = 1
        #else:
        #    print "move was good"
        
        sleep(0.5)
        print policy
        print Vpi
 
def exc_action(a = 2):
    if a == 0:
        if not t.is_pressed():
            m_right.run(_SPEED)
            m_left.run(_SPEED)
    elif a == 1:
        if not t.is_pressed():
            m_left.run(-_SPEED)
            m_right.run(-_SPEED)
    elif a == 2:
        stop_all()
    else: 
        stop_all()

def drive(r = 80,l = 80):
        
    if r > 100:
        r = 100
    elif r < 30:
        r = 30
    if l > 100:
        l = 100
    elif l < 30:
        l = 30
    print "right: ",r,"\tleft: ",l
    m_right.run(r)
    m_left.run(l)    

def stop_all():
    m_right.brake()
    m_left.brake()

if __name__ == "__main__":
    start = time()
    to_wall(TIME_LIMIT)    
    
    stop_all()
    print "I quit."    
    exit()