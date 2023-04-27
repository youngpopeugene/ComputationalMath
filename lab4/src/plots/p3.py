import matplotlib.pyplot as plt
import numpy as np
import sys

arg1 = sys.argv[1]
arg2 = sys.argv[2]
arg3 = sys.argv[3]
arg4 = sys.argv[4]
arg5 = sys.argv[5]
arg6 = sys.argv[6]

x = np.arange(float(arg1), float(arg2), 0.1)
y = float(arg3) * x ** 3 + float(arg4) * x ** 2 + float(arg5) * x + float(arg6)

plt.plot(x, y)
plt.title('P3(x) = (' + arg3 + ')x^3 + (' + arg4 + ')x^2 + (' + arg5 + ')x + (' + arg6 + ')')
plt.xlabel('x')
plt.ylabel('y')
plt.show()
