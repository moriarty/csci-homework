from sklearn.svm import SVR
import numpy as np
n_samples, n_features = 10, 0
np.random.seed(0)
y = np.random.randn(n_samples)
x = np.random.randn(n_samples, n_features)
clf = SVR(C=1.0, epsilon=0.2)
clf.fit(x,y)
print clf.score(x,y)
