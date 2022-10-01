import matplotlib.pyplot as plt
import math
import numpy as np

x =  np.linspace(2,4.5,50)
y1 = np.tan(x)
y2 = np.linspace(0,0,50)
plt.plot(x,y1)
plt.plot(x, y2) 
# when you want to give a label
plt.xlabel('x')
plt.legend(["$tan(x)$"])
plt.show()