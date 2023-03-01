import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-10,10,1000)

y = 4*np.sin(x) + 1 - x

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1)
ax.set_title('f(x) = 4 * sin(x) + 1 - x')
ax.plot(x, y)
ax.spines.left.set_position('zero')
ax.spines.right.set_color('none')
ax.spines.bottom.set_position('zero')
ax.spines.top.set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.yaxis.set_ticks_position('left')

plt.plot(x,y, 'r')

plt.show()