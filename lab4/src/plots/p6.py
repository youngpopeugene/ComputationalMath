import math
import matplotlib.pyplot as plt
import numpy as np
import sys

arg1 = sys.argv[1]
arg2 = sys.argv[2]
arg3 = sys.argv[3]
arg4 = sys.argv[4]

x = np.arange(float(arg1), float(arg2), 0.1)
y = (math.e) ** ((x - float(arg4)) / float(arg3))

plt.plot(y, x)
plt.title('P6(x) = (' + arg3 + ')*ln(x) + (' + arg4 + ')')
plt.xlabel('x')
plt.ylabel('y')
plt.show()
