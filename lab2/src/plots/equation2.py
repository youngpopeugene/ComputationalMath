import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-2,8,1000)

y = (np.e)**(-1*x) - 0.5*(np.sin(x))**2

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1)
ax.set_title('f(x) = e^(-x) - 1/2 * sin^2(x)')
ax.plot(x, y)
ax.spines.left.set_position('zero')
ax.spines.right.set_color('none')
ax.spines.bottom.set_position('zero')
ax.spines.top.set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.yaxis.set_ticks_position('left')

plt.plot(x,y, 'r')

plt.show()