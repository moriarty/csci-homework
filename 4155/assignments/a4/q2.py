"""
@author: Alex Moriarty

CSCI 4155 Machine Learning: Assignment 4.
Gradient decent to learn regression of X,Y data.
"""

from pylab import *
from sklearn.svm import SVC
import numpy as np
from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt


DATA_TRAIN_FILE = 'A4Q2_train_data.npy'
DATA_TRAIN_LABELS_FILE = 'A4Q2_train_labels.npy'
DATA_TEST_FILE = 'A4Q2_test_data.npy'

Training = np.load(DATA_TRAIN_FILE)
Labels = np.load(DATA_TRAIN_LABELS_FILE)
Test = np.load(DATA_TEST_FILE)

#print Test.size
#print Labels.size
#print Training.size

''' This is important. It's also magic. '''
clf = SVC()
clf.fit(Training, Labels)

''' This is just graphing the Data '''
fig1 = plt.figure()
ax1 = fig1.add_subplot(111, projection='3d')
for i in np.arange(Training[:,0].size):
    if Labels[i] == 0:
        ax1.scatter(Training[i][0], Training[i][1], Training[i][2], c='r', marker='o')
    else:
        ax1.scatter(Training[i][0], Training[i][1], Training[i][2], c='y', marker='^')            

''' This sets up an empty vector to hold our predictions'''
myLabels = np.zeros(Test[:,0].size)
''' This starts the plot for our data results. Not important'''
fig2 = plt.figure()
ax2 = fig2.add_subplot(111, projection='3d')


''' this is where the magic happens '''
for i in np.arange(Test[:,0].size):
    ''' using the clf magic from above, mage a prediction '''
    ''' Test[i] is 3 numbers, and the output of predict is one class '''
    ''' The predicted class for test[i] is saved into myLabels[i] '''
    myLabels[i] = clf.predict(Test[i])
    ''' This if else just plots the data '''
    if myLabels[i] == 0:
        '''If it was class 0, plot a red circle'''
        ax2.scatter(Test[i][0], Test[i][1], Test[i][2], c='r', marker='o')
    else:
        '''Otherwise plot a yellow triangle '''
        ax2.scatter(Test[i][0], Test[i][1], Test[i][2], c='y', marker='^')

''' This gives you the score, which is how well it 
thought it did on the data '''
print clf.score(Test, myLabels)

''' saves the results in the file '''
np.save('myLabels.npy', myLabels)

''' shows all the plots '''
plt.show()