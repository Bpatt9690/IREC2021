import os
import socket
import time
import _thread

actuatorA = False
actuatorB  = False
loadCellData = False
loadCellValues = 0

def actuatorOpen(segment,s):

	global actuatorA
	global actuatorB
	
	if segment == 'A':
		s.send('ao'.encode())
		print('Opening Actuator A')
		time.sleep(15)
		actuatorA = True

	else:
		s.send('bo'.encode())
		print('Opening Actuator B')
		time.sleep(15)
		actuatorB = True

def actuatorClose(segment,s):

	global actuatorA
	global actuatorB
	
	if segment == 'A':
		s.send('ac'.encode())
		print('Closing Actuator A')
		time.sleep(15)
		actuatorA = False

	else: 	
		s.send('bc'.encode())
		print('Closing Actuator B')
		time.sleep(15)
		actuatorB = False

def loadCellData(s):

	global loadCellData

	s.send('lc'.encode())

	if loadCellData is False:
		loadCellData is True

	elif loadCellData is True:
		loadCellData is False

	try:
		_thread.start_new_thread(loadCellAcquisition)

	except:
		print('Error creating loadCell thread')


def loadCellAcquisition():

	global loadCellValues

	s = socket.socket()
	s.connect(('raspberrypi',8893))
	clearScreen()

	while True:	
		loadCellValues = c.recv(1024).decode()
		print(loadCellValues)
		time.sleep(.5)

def ignition(s):

	t = 0

	while(t < 5):
		print('Ignition in '+str(5-t))

		if t == 0:
			s.send('ig'.encode())

		t += 1
		time.sleep(1)
		clearScreen()

	#print('ignition sequence started')
	#s.send('ig'.encode())
	time.sleep(20)


def exitProgram(socketClass):
	print('Ad Astra')
	socketClass.killSocket()
	exit()

def userInputSelection(selection,socketClass):

	if 0 < selection < 7:

		options ={
			1 : actuatorOpen,
	        2 : actuatorClose,
	        3 : actuatorOpen,
	        4 : actuatorClose,
	        5 : loadCellData,
	        6 : ignition,
	        7.: exitProgram
		}

		if int(selection) in {1,2}:
			clearScreen()
			options.get(selection)('A',socketClass)

		elif int(selection) in {3,4}:
			clearScreen()
			options.get(selection)('B',socketClass)

		elif int(selection) is 5:
			clearScreen()
			loadCellData(socketClass)

		elif int(selection) is 6:
			clearScreen()
			ignition(socketClass)

		elif int(selection) is 7:
			exitProgram(socketClass)

def clearScreen():
	os.system('clear')

def main():

	s = socket.socket()
	s.connect(('raspberrypi',8893))

	while(True):

		clearScreen()
		print("\n\n\t\tIREC2020 Cold Flow Test\n")
		print("Please pick an option, from the list below:\n")
		print("1.) Open Actuator A\n")
		print("2.) Close Actuator A\n")
		print("3.) Open Actuator B\n")
		print("4.) Close Actuator B\n")
		print("5.) Load Cell Data Acquistion\n")
		print("6.) Ignition\n")
		print("7.) Exit Program")
		print("\n\n\t\tCurrent Status\n")
		print(('Actuator A: Open','Actuator A: Closed')[actuatorA is False]+'\n')
		print(('Actuator B: Open','Actuator B: Closed')[actuatorB is False]+'\n')
		print(('Load Cell Data: Online','Load Cell Data: Offline')[loadCellData is False]+'\n')
		print('Load Cell Values:', str(loadCellValues)+'\n')
		userInput = input("Selection: ")

		if userInput.isdigit():
			userInputSelection(int(userInput),s)
		else:
			print("Please enter A Valid Selection")
			time.sleep(2)

if __name__ == "__main__":
	main()