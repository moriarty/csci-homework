from matplotlib.pyplot import *
from pylab import *
from mpl_toolkits.mplot3d import Axes3D

SIGMA = array([[1, 0.5],[0.5,1]])

X,Y = mgrid[-2:4:.1, -2:4:.1]



part1 = ((linalg.det(2*pi*SIGMA))**(-0.5))

part2 = dot((x-MU), dot(sigma,(x-MU))

print part2

part3 = exp(-0.5*part2)

Z=part1*part3

ax = gca(projection='3d')
ax.plot_surface(X,Y,Z, rstride=1,cstride=1,cmap=cm.jet, linewidth=0,antialiased=False)
show()
