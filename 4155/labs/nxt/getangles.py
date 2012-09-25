'''
@author: moriarty
'''
import math as mth
from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *


import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
from pylab import *

TIME_LIMIT = 120
b = find_one_brick()
m_1 = Motor(b,PORT_A)
m_2 = Motor(b,PORT_B)
s_touch = Touch(b, PORT_1)

X, Y = mgrid[0:360:1,0:360:1]
Z = zeros_like(X)
myX = []
myY = []

def measure_angles():
    start = time()
    while time()-start < TIME_LIMIT:
        get_values()
        if s_touch.get_sample():
            return
        

def get_values():
    v1 = m_1.get_tacho().tacho_count % 360
    v2 = m_2.get_tacho().tacho_count % 360
    '''Z[v1][v2] = 1'''
    myX.append(v1)
    myY.append(v2)

    
if __name__=="__main__":
    
    print "Will now measure angles for ",TIME_LIMIT," seconds"
    print "Push touch sensor to finish sooner."
    measure_angles()
    print "Plotting"
    print "this is slow... "

    '''
    fig = plt.figure()
    ax = fig.gca(projection='3d')
    surf = ax.plot_surface(X, Y, Z, rstride=1, cstride=1, cmap=cm.jet, linewidth=0, antialiased=False)
    ax.set_zlim(-1.01, 1.01)
    ax.zaxis.set_major_locator(LinearLocator(10))
    ax.zaxis.set_major_formatter(FormatStrFormatter('%.02f'))
    plt.show()
    '''
    plot(myX,myY)
    
    '''
    
    fig = plt.figure()
    ax = fig.gca(projection='3d')
    X, Y, Z = axes3d.get_test_data(0.05)
    cset = ax.contour(X, Y, Z, extend3d=True)
    ax.clabel(cset, fontsize=9, inline=1)
    '''
    plt.show()
    
    print 'I quit'
    exit()
