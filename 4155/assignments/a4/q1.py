"""
@author Alex Moriarty

CSCI 4155 Machine Learning: Assignment 4.
Gradient decent to learn regression of X,Y data.
"""

import numpy as np
import matplotlib.pyplot as plt

# Input Data
DATA_FILE = '/Users/alex/Downloads/A4Q1_data.npy'

MAX_ITR = 300   # chosen arbitrarily
ALPHA = 0.05     # chosen arbitrarily
# From experiments ALPHA must be at least 0.05

Data = np.load(DATA_FILE)

X = Data[0,:]
Y = Data[1,:]

plt.plot(X,Y,'o')

m = float(Y.size)
# add a column of ones to X
X = np.c_[np.ones(m), X]
# initialize theta to zeros
theta = np.zeros(X[0,:].size)

for i in np.arange(MAX_ITR):
    grad = np.dot(1/m*X.T,np.dot(X,theta)-Y)
    theta = theta - np.dot(ALPHA, grad)

plt.plot(X[:,1], np.dot(X,theta), '-')
plt.show()