# -*- coding: utf-8 -*-
"""
Spyder Editor

This temporary script file is located here:
C:\Users\moriarty.PENTAGON\.spyder2\.temp.py
"""
from pylab import *

foo = 0
tmp = []

for j in range(1000):
    foo = randn(7)
    s = 0
    for i in foo:
        s +=foo[i]
    tmp.append(s)

hist(tmp,100)

show()