# -*- coding: utf-8 -*-
"""
Created on Wed Oct 10 22:35:00 2012

@author: alex
"""

from pylab import *
from sklearn.svm import SVC
import numpy as np


#DATA_TRAIN_FILE = 'A4Q2_train.npy'
#DATA_TRAIN_LABELS_FILE = 'A4Q2_train_labels.npy'
#DATA_TEST_FILE = 'A4Q2_test.npy'

#Training = np.load(DATA_TRAIN_FILE)
#Labels = np.load(DATA_TRAIN_LABELS_FILE)
#Test = np.load(DATA_TEST_FILE)

#train_data, test_data = Training[:-100], Training[-100:]
#train_labels, test_labels = Labels[:-100], Labels[-100:]

#clf = SVC()
#clf.fit(Training, Labels)
#p=svc.predict(test_data).astype(bool)

#print clf.predict(Test[:,:])

N = 300; seed(12345)
r1, r2 = 2+rand(N), randn(N)
a1, a2 = 2*pi*rand(N), 0.5*pi*rand(N)
figure("predict the label")
polar(a1,r1,'.',a2,r2,'.')

#print r1
#print r2

order = permutation(len(r1)+len(r2))
r = append(r1,r2)[order]; a = append(a1,a2)[order];

labels = append(zeros(N), ones(N))[order];
xy = array([r*cos(a), r*sin(a)]).T
train_data, test_data = xy[:-50], xy[-50:]
train_labels, test_labels = labels[:-50], labels[-50:]

svc = SVC()
svc.fit(train_data, train_labels)
print svc.score(train_data, train_labels)
p=svc.predict(test_data).astype(bool)


figure("Predictions");
polar((a[-50:])[-p], (r[-50:])[-p],'.',
      (a[-50:])[p],(r[-50:])[p],'.')

show()