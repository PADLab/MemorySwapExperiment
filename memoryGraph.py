import matplotlib
import matplotlib.pyplot as plt
import csv
import sys
import getopt

def main(argv):
   minVal = ''
   maxVal = ''
   try:
      opts, args = getopt.getopt(argv,"hi:o:",["minvalue=","maxvalue="])
   except getopt.GetoptError:
      print 'test.py -i <minvalue> -o <maxvalue>'
      sys.exit(2)
   for opt, arg in opts:
      if opt == '-h':
         print 'test.py -i <minvalue> -o <maxvalue>'
         sys.exit()
      elif opt in ("-i", "--minvalue"):
         minVal = arg
      elif opt in ("-o", "--maxvalue"):
         maxVal = arg
   plotGraph(minVal, maxVal)


def plotGraph(minVal, maxVal):
	x = []
	y1 = []
	y2 = []

	#print("Opening file")

	plt.rc('font',family='Times New Roman')
	matplotlib.font_manager._rebuild()

	with open('output' + str(minVal) + '-' + str(maxVal) +  '.txt','r') as csvfile:
		plots = csv.reader(csvfile, delimiter=',')
		for row in plots:
			x.append(row[0])
			y1.append(row[3])
			y2.append(row[2])

	plt.grid(True)

	fig = plt.figure()
	ax1 = fig.add_subplot(111)
	ax1.plot(x, y1)
	ax1.set_ylabel('Memory Used (MB)')
	ax1.set_xlabel('Time elapsed (ms)')

	#print ("First subplot complete")

	ax2 = ax1.twinx()
	ax2.plot(x, y2, 'r-')
	ax2.set_ylabel('Object Growth', color='r')
	for tl in ax2.get_yticklabels():
		tl.set_color('r')
    
	#print ("Plot complete. Saving...")

	plt.savefig('mem' + str(minVal) + '-' + str(maxVal) + '.pdf')

	#print ("Saved. Quitting...")
	
if __name__ == "__main__":
   main(sys.argv[1:])