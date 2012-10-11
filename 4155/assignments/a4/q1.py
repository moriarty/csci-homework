"""
@author Alex Moriarty

CSCI 4155 Machine Learning: Assignment 4.
Gradient decent to learn regression of X,Y data.
"""

import numpy as np
import matplotlib.pyplot as plt

# Input Data
DATA_FILE = 'A4Q1_data.npy'

MAX_ITR = 200   # chosen arbitrarily
ALPHA = 0.05     # chosen arbitrarily
# From experiments ALPHA must be at least 0.05

Data = np.load(DATA_FILE)

X = Data[0,:]
Y = Data[1,:]

fig1 = plt.figure()
ax1 = fig1.add_subplot(111)
p1a, = ax1.plot(X,Y,'o')

m = float(Y.size)
# add a column of ones to X to allow for matrix math
X = np.c_[np.ones(m), X]
# initialize theta to zeros
theta = np.zeros(X[0,:].size)
gvals = np.zeros([MAX_ITR,2])
err = np.zeros([MAX_ITR,1])

for i in np.arange(MAX_ITR):
    grad = np.dot(1/m*X.T,np.dot(X,theta)-Y)
    theta = theta - np.dot(ALPHA, grad)
    gvals[i] = grad

# What is the guess for x = 20?
v20 = np.dot([1, 20],theta)
print "the guess for x=20 is ",v20

R = np.c_[np.ones(MAX_ITR)*gvals[MAX_ITR-1][0], np.ones(MAX_ITR)*gvals[MAX_ITR-1][1]]
err = np.sqrt((R[:,0]-gvals[:,0])**2 + (R[:,1]-gvals[:,1])**2)
err = np.c_[np.arange(MAX_ITR)+np.ones(MAX_ITR), err]

#print theta

p1b, = ax1.plot(X[:,1], np.dot(X,theta), '-')
p1c, = ax1.plot(20, v20, 'ro')

plt.legend([p1a, p1b, p1c], ["Data","Reg","Prediction"], loc=4, borderaxespad=1.0)

fig2 = plt.figure()
ax2 = fig2.add_subplot(111)
ax2.plot(err[:,0],err[:,1],'.')

'''

theta0_vals = np.linspace(-10, 20, 100);
theta1_vals = np.linspace(0, 6, 100);

J_vals = np.zeros((theta0_vals.size, theta1_vals.size));

for i in np.arange(theta0_vals.size)
	for j in np.arange(theta1_vals.size)
		t = [theta0_vals(i); theta1_vals(j)];    
		J_vals(i,j) = (0.5/m) .* (x * t - y)' * (x * t - y);
    end
end

J_vals = J_vals'
% Surface plot
figure;
surf(theta0_vals, theta1_vals, J_vals)
xlabel('\theta_0'); ylabel('\theta_1');

% Contour plot
figure;
contour(theta0_vals, theta1_vals, J_vals , linspace(0, 50,50))
xlabel('\theta_0'); ylabel('\theta_1');
'''
plt.show()