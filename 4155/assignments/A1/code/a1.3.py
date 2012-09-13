from matplotlib.pyplot import *
from pylab import *
from mpl_toolkits.mplot3d import Axes3D

SIGMA = array([[1, 0.5],[0.5,1]])
MU = array([[1],[2]])


X,Y = mgrid[-2:4:.1, -2:4:.1]

x = array([[X],[Y]])

part1 = ((linalg.det(2*pi*SIGMA))**(-0.5))

part2 = (-0.5)*(x-MU).conj().transpose()*linalg.inv(SIGMA)*(x-MU)

 part2

part3 = exp(-0.5*part2)
part3

Z=part1*part3

ax = gca(projection='3d')
ax.plot_surface(X,Y,Z, rstride=1,cstride=1,cmap=cm.jet, linewidth=0,antialiased=False)
show()

