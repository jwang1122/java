import matplotlib.pyplot as plt
# page 110, 115
x = [i for i in range(100)]
y1 = [i*i for i in range(100)]
y2 = [.25*i*i + 5*i + 1 for i in range(100)]
y3 = [5*i + 1 for i in range(100)]
plt.plot(x,y1)
plt.plot(x,y2)
plt.plot(x, y3)
 
# when you want to give a label
plt.xlabel('n')
plt.ylabel('Algorithms')
plt.legend(["$n^2$","$.25n^2+5n+1$","$5n+1$"])
plt.show()