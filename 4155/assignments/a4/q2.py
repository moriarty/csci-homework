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


DATA_TRAIN_FILE = 'A4Q2_train.npy'
DATA_TRAIN_LABELS_FILE = 'A4Q2_train_labels.npy'
DATA_TEST_FILE = 'A4Q2_test.npy'

Training = np.load(DATA_TRAIN_FILE)
Labels = np.load(DATA_TRAIN_LABELS_FILE)
Test = np.load(DATA_TEST_FILE)

clf = SVC()
clf.fit(Training, Labels)
print clf.score(Training, Labels)

fig1 = plt.figure()
ax1 = fig1.add_subplot(111, projection='3d')
for i in np.arange(Training[:,0].size):
    if Labels[i] == 0:
        ax1.scatter(Training[i][0], Training[i][1], Training[i][2], c='r', marker='o')
    else:
        ax1.scatter(Training[i][0], Training[i][1], Training[i][2], c='b', marker='^')            


fig2 = plt.figure()
ax2 = fig2.add_subplot(111, projection='3d')
for i in np.arange(Test[:,0].size):
    if clf.predict(Test[i]) == 0:
        ax2.scatter(Test[i][0], Test[i][1], Test[i][2], c='r', marker='o')
    else:
        ax2.scatter(Test[i][0], Test[i][1], Test[i][2], c='b', marker='^')            

print Test[0]

print clf.predict(Test[0])
plt.show()