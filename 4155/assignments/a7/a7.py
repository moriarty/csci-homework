'''
'''
from math import *
from nxt.locator import *
from nxt.motor import *
from nxt.sensor import *
from time import *
from pylab import *
from sklearn.svm import SVC
import itertools as itt
from mpl_toolkits.mplot3d import Axes3D
from matplotlib import cm
import matplotlib.pyplot as plt

from vision import *

_armLength = 10;
_angle_err = 5
_n = 100

b = find_one_brick()
m_1 = Motor(b, PORT_B)
m_2 = Motor(b, PORT_C)
	
v = Vision()
clf = SVC(kernel='linear')

labels = np.zeros([_n,])
data = np.zeros([_n,2])

def main():	
	for i in range(10):
		print i , get_angle()

def get_angle():
	return m_1.get_tacho().tacho_count % 360

def guess_pose(angle, err = _angle_err):
	new_angle = angle + (0.5 - rand())*err
	return _armLength*degrees(cos(new_angle))

def move_rand():
	for i in range (10):
		if i%2==0:
			d = 1
		else: 
			d = -1
		m_1.turn( d*20,120,False)
		m_2.turn(-20,120,False)


def train():
	global data
	global labels
	global clf
	for i in range (_n):
		if i%2==0:
			d = 1
		else: 
			d = -1
		m_1.turn( d*20,120,False)
		m_2.turn(-20,120,False)


		l = get_angle()
		d = v.get_local()
		if d == None:
			i = i + 1
		else:
			print i, l, d
			labels[i] = l
			data[i] = d
			print "data",d

	#print labels
	#print data

	foo = np.where(data[:,0])
	#bar = labels[3:,]

	data = data[foo]
	labels = labels[foo]
	print data

	#data = foo
	#labels = bar
	np.save('myData.npy', data)
	np.save('myLabels.npy', labels)
	clf.fit(data, labels)



def get_pose():
	x = _armLength*degrees(cos(get_angle()))
'''
def kf_predict(X, P, A, Q, B, U):
	# X mean state estimate of K-1
	# P state covariance
	# A Transition matrix Q noise matrix
	# B input effect matrix
	# U control input
	X = np.dot(A, X) + np.dot(B, U)
	P = np.dot(A, np.dot(P, A.T)) + Q
	return(X,P)

def kf_update(X, P, Y, H, R):
	IM = np.dot(H,X)
	IS = R + dot(H, dot(P, H.T))
	K = dot(P, dot(H.T, np.linalg.inv(IS)))
	X = X + dot(K, (Y-IM))
	P = P - dot(K, dot(IS, K.T))
	LH = gauss_pdf(Y, IM, IS)
	return (X, P, K, IM, IS, LH)

def gauss_pdf(X, M, S):
	if M.shape()[1] == 1:
	DX = X - tile(M, X.shape()[1])
	E = 0.5 * sum(DX * (dot(inv(S), DX)), axis=0)
	E = E + 0.5 * M.shape()[0] * log(2 * pi) + 0.5 * log(det(S))
	P = exp(-E)
	elif X.shape()[1] == 1:
	DX = tile(X, M.shape()[1])- M
	E = 0.5 * sum(DX * (dot(inv(S), DX)), axis=0)
	E = E + 0.5 * M.shape()[0] * log(2 * pi) + 0.5 * log(det(S))
	P = exp(-E)
	else:
	DX = X-M
	E = 0.5 * dot(DX.T, dot(inv(S), DX))
	E = E + 0.5 * M.shape()[0] * log(2 * pi) + 0.5 * log(det(S))
	P = exp(-E)
	return (P[0],E[0])
'''

if __name__ == '__main__':
	#move_rand()
	train()

	#print
	#print TRAINING

	#print clf.predict([[27,27],[30,30],[40,40],[80,80]])

	#Z = np.array(list(itt.product(range(100),repeat=2)))
	#X = np.arange(100)
	#Y = np.arange(100)

	#fig = plt.figure()
	#ax = fig.gca(projection='3d')

	#ax.plot_surface(X,Y,Z)

	#plt.show()

	exit()

