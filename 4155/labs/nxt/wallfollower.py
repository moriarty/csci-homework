# -*- coding: utf-8 -*-
"""
Created on Tue Sep 18 17:13:52 2012

@author: moriarty
"""

## Desired Distance
DIST = 25
TIME_LIMIT = 20
TURN_TIME = 2
START_POWER = 70
_KP = 1
_KI = 0
_KD = 0.25

import math as mth
from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *

b = find_one_brick()
t = Touch(b, PORT_3)
u = Ultrasonic(b, PORT_1)
m_right = Motor(b, PORT_B)
m_left = Motor(b, PORT_C)
m_left.brake()
m_right.brake()
_N = 10
_WB = 10
_MARG = 10

def wallfollower(TIME_LIMIT):
    start = time()
    
    e_last = 0
    p_left = START_POWER
    p_right = START_POWER
    e_sum = 0
    #e_prev = 0
    e_diff = 0
    c = 0
    while time() - start < TIME_LIMIT:
        u_val = u.get_sample()   
        e = u_val - DIST
        print "uval: ",u_val,"\tdist: ",DIST        
        #e = mth.log((u_val+1.0)/DIST)        
        if c % _N == 0:
            e_diff = e - e_last
            e_last = e
        if t.is_pressed():
            stop_all()
            return
        #e_diff = e-e_prev
        e_sum = e_sum + e
        update = controller(e,e_sum,e_diff)
        #upmax = get_upmax(u_val)
        #if update > upmax:
        #    update = upmax
        print "u: ",update
        p_right = START_POWER + update
        p_left = START_POWER - update
        #print "dist: ",u_val,"\te: ",e        
        print_status(e,e_sum,e_diff, update, u_val, start)        
        drive(p_right, p_left)
        #e_prev = e
        
        '''
        (wheelbase/2 + u_val + _MARGIN ) / (u_val + _MARGIN - _Wheelbase/2) = 
        (update_max + START_POWER) / (START_POWER - update_max)
        '''
        
def print_status(p, i, d, update, u_val, start):
        print "p: ",p*_KP,"\ti: ",i*_KI,"\td: ",d*_KD
        print "update: ",update
        print "dist: ",u_val,"\te: ",p
        tr = time() - start
        print "time remaining: ",tr

def controller(p,i,d,kp=_KP,ki=_KI,kd=_KD):
    update = p*kp + i*ki + d*kd
    return update

def get_upmax(u_val):
    upmax = START_POWER * _WB / (2.0*(u_val+_MARG))
    return upmax

def drive(r = 80,l = 80):
        
    if r > 100:
        r = 100
    elif r < 0:
        r = 0
    if l > 100:
        l = 100
    elif l < 0:
        l = 0
    print "right: ",r,"\tleft: ",l
    m_right.run(r)
    m_left.run(l)    

def turn_left():
    stop_all()
    start_turn = time()
    m_right.run(80)
    while time() - start_turn < TURN_TIME:
        continue
    stop_all()

def stop_all():
    m_right.brake()
    m_left.brake()

if __name__ == "__main__":
    start = time()
    wallfollower(TIME_LIMIT)    
    #while time() - start < TIME_LIMIT:
        #print "dist: ",u.get_sample()
    
    stop_all()
    print "I quit."    
    exit()
