import matplotlib.pyplot as plt
import math
import numpy as np

x =  np.linspace(0.1,10)
y1 = x
y2 = np.log(x)
plt.plot(x,y1)
plt.plot(x,y2)
 
# when you want to give a label
plt.xlabel('n')
plt.ylabel('Algorithms')
plt.legend(["$n$","$log(n)$"])
plt.show()