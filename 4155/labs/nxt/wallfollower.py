# -*- coding: utf-8 -*-
"""
Created on Tue Sep 18 17:13:52 2012

@author: moriarty
"""

## Desired Distance
DIST = 25
TIME_LIMIT = 60
TURN_TIME = 2
START_POWER = 90

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

def wallfollower(TIME_LIMIT):
    start = time()
    
    u_val = u.get_sample()
    p_left = START_POWER
    p_right = START_POWER
    e_sum = 0
    e_prev = 0
    while time() - start < TIME_LIMIT:
        e = DIST - u_val
        e_diff = e-e_prev
	update = controller(e,e_sum,e_diff)
	p_right = START_POWER - update
	p_left = START_POWER + update
        drive(p_right, p_left)
	e_prev = e

def controller(p,i,d,kp=_KP,ki=_KI,kd=_KD):
    update = p*kp + i*ki + d*kd
    return update

def avoid_walls():
    start = time()
    while time() - start < TIME_LIMIT:
        #Check Ultrasonic Sensor
        u_val = u.get_sample()        
        t_val = t.get_sample()

        if t_val:
            stop_all()
            exit()
        elif u_val < 20:
            turn_left()
        else:
            drive_forward()
    stop_all()
            
def drive(r = 80,l = 80)
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

    avoid_walls()    
    
    exit()
