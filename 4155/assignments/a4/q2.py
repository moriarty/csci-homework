"""
@author: Alex Moriarty

CSCI 4155 Machine Learning: Assignment 4.
Gradient decent to learn regression of X,Y data.
"""

import numpy as np
import matplotlib.pyplot as plt

print 'here'
DATA_TRAIN_FILE = 'A4Q2_train.npy'
DATA_TRAIN_LABELS_FILE = 'A4Q2_train_labels.npy'

Training = np.load(DATA_TRAIN_FILE)
Labels = np.load(DATA_TRAIN_LABELS_FILE)

X = Training[:,0]
Y = Training[:,1]
Z = Training[:,2] 

print 'here'
for i in np.arange(10):
    print 'out'
#    print X[i]," "," ",Y[i]," ",Z[i]," ",Labels[i]

#print Labels.size