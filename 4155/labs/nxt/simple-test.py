"""
Simple Test
By: Alex Moriarty (alexander@dal.ca)
"""

from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *


b = find_one_brick()

t = Touch(b, PORT_2)
u = Ultrasonic(b, PORT_1)
l = Light(b, PORT_3)

i = 0
while i < 10:
    if t.get_sample():
        print 'Touch: ', t.get_sample()
        #print 'Light: ', l.get_sample()
        print 'UltraSonic: ', u.get_sample()
        i = i + 1

exit()