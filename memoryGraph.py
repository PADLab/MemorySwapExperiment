import matplotlib.pyplot as plt
import csv
import numpy as np

x = []
y1 = []
y2 = []

with open('output.txt','r') as csvfile:
    plots = csv.reader(csvfile, delimiter=',')
    for row in plots:
        x.append(row[0])
        y1.append(row[3])
        y2.append(row[2])

#max_val = int(max(x))

fig = plt.figure()
ax1 = fig.add_subplot(111)
ax1.plot(x, y1)
ax1.set_ylabel('Memory Used')
ax1.set_xlabel('Time elapsed (ms)')
#ax1.hlines(256, 0, max_val, linewidth=1, color='g')
#ax1.hlines(512, 0, max_val, linewidth=1, color='g')
#ax1.hlines(768, 0, max_val, linewidth=1, color='g')
#ax1.hlines(1024, 0, max_val, linewidth=1, color='g')
#ax1.hlines(1280, 0, max_val, linewidth=1, color='g')
#ax1.hlines(1576, 0, max_val, linewidth=1, color='g')
#ax1.hlines(1792, 0, max_val, linewidth=1, color='g')
#ax1.hlines(2048, 0, max_val, linewidth=1, color='g')



ax2 = ax1.twinx()
ax2.plot(x, y2, 'r-')
ax2.set_ylabel('Object Growth', color='r')
for tl in ax2.get_yticklabels():
    tl.set_color('r')

plt.savefig('mem-256.png')