# -*- coding: utf-8 -*-
"""
Line Follower
By: Alex Moriarty (alexander@dal.ca)

Location: 
"""

from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *

TIME_LIMIT = 15

b = find_one_brick()

t = Touch(b, PORT_3)
s = Sound(b, PORT_1)
l = Light(b, PORT_4)
print 'Light: ', l.get_sample()

m_right = Motor(b, PORT_B)
m_left = Motor(b, PORT_C)

l.set_illuminated(True)

start = time()

while time() - start < TIME_LIMIT:
    print time()-start
    
    # Check Light sensor
    l_val = l.get_sample()    
    
    print l_val
    if l_val < 500:
        m_left.brake()
        m_right.run(85)
    else:
        m_right.brake()
        m_left.run(85)

m_left.brake()
m_right.brake()

exit()