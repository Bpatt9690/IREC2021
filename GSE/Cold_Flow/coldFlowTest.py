import os
import socket
import time

actuatorA = False
actuatorB  = False
loadCellData = False

def actuatorOpen(segment,s):

	global actuatorA
	global actuatorB
	
	if segment == 'A':
		s.send('ao'.encode())
		print('Opening Actuator A')
		time.sleep(10)
		actuatorA = True

	else:
		s.send('bo'.encode())
		print('Opening Actuator B')
		time.sleep(10)
		actuatorB = True

def actuatorClose(segment,s):

	global actuatorA
	global actuatorB
	
	if segment == 'A':
		s.send('ac'.encode())
		print('Closing Actuator A')
		time.sleep(10)
		actuatorA = False

	else: 	
		s.send('bc'.encode())
		print('Closing Actuator B')
		time.sleep(10)
		actuatorB = False

def loadCellDataTransfer(socketClass):

	print('load cell')

def ignition():

	s.send('ig'.encode())
	t = 0

	while(t < 10)
		print('Ignition in'+str(10-t))
		t += 1
		time.sleep(1)
		clearScreen()

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
	        5 : loadCellDataTransfer,
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
			loadCellDataTransfer(socketClass)

		elif int(selection) is 6:
			clearScreen()
			ignition()

		elif int(selection) is 7:
			exitProgram(socketClass)

def clearScreen():
	os.system('clear')

def main():

	s = socket.socket()
	s.connect(('pi',8893))

	while(True):

		clearScreen()

		print("\n\n\t\tIREC2020 Cold Flow Test\n")
		print("Please pick an option, from the list below:\n")
		print("1.) Open Actuator A\n")
		print("2.) Close Actuator A\n")
		print("3.) Open Actuator B\n")
		print("4.) Close Actuator B\n")
		print("5.) Load Cell Data Acquistion\n")
		print("6.) Ignition")
		print("7.) Exit Program")
		print("\n\n\t\tCurrent Status\n")
		print(('Actuator A: Open','Actuator A: Closed')[actuatorA is False]+'\n')
		print(('Actuator B: Open','Actuator B: Closed')[actuatorB is False]+'\n')
		print(('Load Cell Data: Online','Load Cell Data: Offline')[loadCellData is False]+'\n')

		userInput = input("Selection: ")
		userInputSelection(int(userInput),s)

if __name__ == "__main__":
	main()