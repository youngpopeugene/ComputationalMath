import matplotlib.pyplot as plt
import numpy as np
import sys

arg1 = sys.argv[1]
arg2 = sys.argv[2]
arg3 = sys.argv[3]
arg4 = sys.argv[4]
arg5 = sys.argv[5]

x = np.arange(float(arg1), float(arg2), 0.1)
y = float(arg3) * x ** 2 + float(arg4) * x + float(arg5)

plt.plot(x, y)
plt.title('P2(x) = (' + arg3 + ')x^2 + (' + arg4 + ')x + (' + arg5 + ')')
plt.xlabel('x')
plt.ylabel('y')
plt.show()
