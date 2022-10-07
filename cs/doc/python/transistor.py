import pandas as pd
import matplotlib.pyplot as plt
from matplotlib import font_manager

df = pd.read_csv('cs/doc/python/transistor.csv')

df.plot(x='LED',y=['Vc','Vd','I1'])

plt.show()