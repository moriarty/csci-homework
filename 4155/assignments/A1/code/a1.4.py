from matplotlib.pyplot import *
from pylab import *
from mpl_toolkits.mplot3d import Axes3D

def foo_func(a,b):
    return a*(b.conj().transpose())**2 + b

if __name__ == '__main__':
    a = randn(10)
    b = randn(10)

    print foo_func(a,b)
