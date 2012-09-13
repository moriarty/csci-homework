from matplotlib.pyplot import *
from pylab import *
from mpl_toolkits.mplot3d import Axes3D
SIGMA = matrix([[1, 0.5],[0.5,1]])
MU = matrix([2, 1])
X,Y = mgrid[-2:4:.1, -2:4:.1]

part1 = ((2*pi)**(0.5))**(X.shape[0])
part2 = det(SIGMA)**(-0.5)
part3 = matrix([X[:,0]-ones(X[:,0].shape)*MU[0,0], Y[0,:]-ones(Y[:,0].shape)*MU[0,1]])

Z = part1*part2* exp(-0.5* part3.T * inv(SIGMA) * part3 )

ax = gca(projection='3d')
ax.plot_surface(X,Y,Z, rstride=1,cstride=1,cmap=cm.jet, linewidth=0,antialiased=False)
show()
