
"""
@author: Alex Moriarty

CSCI 4155 Machine Learning: Assignment 4.
Test my Labels vs Actual Labels.
"""

from pylab import *
#from sklearn.svm import SVC
import numpy as np
#from mpl_toolkits.mplot3d import Axes3D
#import matplotlib.pyplot as plt

DATA_MY_LABELS = 'myLabels.npy'
DATA_TEST_LABELS = 'A4Q2_test_labels.npy'

Labels = np.load(DATA_MY_LABELS)
Test = np.load(DATA_TEST_LABELS)

''' sum will be the number of correct labels '''
sum = 0.0

for i in np.arange(Labels.size):
    if Labels[i] == Test[i]:
        ''' if we labeled it correctly, add one to sum. '''
        sum = sum + 1
''' Divide the number of correct labels by all the labels. '''
print sum/Labels.size