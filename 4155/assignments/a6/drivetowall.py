'''
'''
import math as mth
from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *


def main():	
	b = find_one_brick()
	t = Touch(b, PORT_1)
	u = Ultrasonic(b, PORT_4)

	m_right = Motor(b, PORT_B)
	m_left = Motor(b, PORT_C)
	m_left.brake()
	m_right.brake()



if __name__ == '__main__':
	main()
