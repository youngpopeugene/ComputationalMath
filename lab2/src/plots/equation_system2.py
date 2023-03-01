import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-10,10,1000)

y = 1.5 - np.cos(x)
z =  (1 + np.sin(x - 0.5))/2

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1)
ax.set_title('[1] cos(x) + y = 1,5 — red\n[2] 2x - sin(y - 0,5) = 1 — green')
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