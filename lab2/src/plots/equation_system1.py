import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-10,10,1000)

y = np.sin(x - 0.6) - 1.6
z = (0.9+np.cos(x))/3

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1)
ax.set_title('[1] sin(x - 0,6) - y = 1,6 — red\n[2] 3x - cos(y) = 0,9 — green')
ax.plot(x, y)
ax.spines.left.set_position('zero')
ax.spines.right.set_color('none')
ax.spines.bottom.set_position('zero')
ax.spines.top.set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.yaxis.set_ticks_position('left')

plt.plot(x,y, 'r')
plt.plot(z,x, 'g')

plt.show()