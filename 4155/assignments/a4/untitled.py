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

