import pandas as pd
import matplotlib.pyplot as plt
from matplotlib import font_manager

df = pd.read_csv('cs/doc/python/transistor.csv')
df['Ib'] = (df['Va']-df['Vb'])/1600-df['Vc']/1800
df['Ic'] = df['I1']- (df['Va']-df['Vb'])/1600
df['Beta'] = df['Ic']/df['Ib']
df.plot(x='LED',y=['Ic','Ib'])

plt.show()

x=df['LED']
y=df['Beta']
plt.ylim(bottom=0,top=350)
plt.plot(x,y,marker='^')
plt.show()