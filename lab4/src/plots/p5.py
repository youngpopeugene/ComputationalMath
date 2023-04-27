import math
import matplotlib.pyplot as plt
import numpy as np
import sys

arg1 = sys.argv[1]
arg2 = sys.argv[2]
arg3 = sys.argv[3]
arg4 = sys.argv[4]

x = np.arange(float(arg1), float(arg2), 0.1)
y = float(arg3) * math.e ** (float(arg4) * x)

plt.plot(x, y)
plt.title('P5(x) = (' + arg3 + ')*e^(' + arg4 + 'x)')
plt.xlabel('x')
plt.ylabel('y')
plt.show()
