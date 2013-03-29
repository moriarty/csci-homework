# -*- coding: utf-8 -*-
"""
Created on Thu Sep 13 17:25:04 2012

@author: moriarty
"""

from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *

TIME_LIMIT = 10

b = find_one_brick()

t = Touch(b, PORT_1)
l = Light(b, PORT_3)
u = Ultrasonic(b, PORT_4)
l.set_illuminated(True)

m_right = Motor(b, PORT_B)
m_left = Motor(b, PORT_C)

DISTANCE = 25

def run_wallfollower():
    d = get_dist()    
    
    if (d > 25 ):
        wander()    
    
    
    
    while True:
        d = get_dist()
        

    return

def stop_all():
    m_left.brake()
    m_right.brake()

def get_dist():
    return u.get_sample()    
    
def follow():    
    return    
    
def drive_forward(speed = 85):
    m_right.run(speed)
    m_left.run(speed)
    return

def drive_left(rate):
    return    
    
def drive_right(rate):
    return    
    
def turn():
    return

def wander():
    return

if __name__ == "__main__":

    #run_wallfollower()
    print get_dist()   
    
    exit()