'''
@author: moriarty
'''
import math as mth
from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *

import matplotlib.pyplot as plt

_TIME_LIMIT = 120
b = find_one_brick()
m_1 = Motor(b,PORT_A)
m_2 = Motor(b,PORT_B)
s_touch = Touch(b, PORT_1)

a1 = []
a2 = []

def measure_angles():
    start = time()
    while time() - start < _TIME_LIMIT:
        if s_touch.get_sample():
            print_values()
            sleep(1)
    

def print_values():
    v1 = m_1.get_tacho().tacho_count
    v2 = m_2.get_tacho().tacho_count
    print 'motor 1: ', v1
    print 'motor 2: ', v2
    print '-------------'
    a1.append(v1)
    a2.append(v2)


if __name__=="__main__":
    
    measure_angles()
    
    print 'I quit'
    exit()
