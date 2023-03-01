import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-5,5,1000)

y = 2 - x**2
z =  2 - x**2

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1)
ax.set_title('[1] x^2 + y = 2 — red\n[2] x + y^2 = 2 — green')
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