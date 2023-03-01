import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-4,4,1000)

y = x**3 - 0.2*x**2 + 0.5*x + 1.5

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1)
ax.set_title('f(x) = х^3 – 0,2x^2 + 0,5x + 1,5')
ax.plot(x, y)
ax.spines.left.set_position('zero')
ax.spines.right.set_color('none')
ax.spines.bottom.set_position('zero')
ax.spines.top.set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.yaxis.set_ticks_position('left')

plt.plot(x,y, 'r')

plt.show()