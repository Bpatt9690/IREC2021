import socket
import RPi.GPIO as GPIO
import time
import subprocess
import _thread
import serial

def openActuator():

	GPIO.setmode(GPIO.BCM)
	GPIO.setup(17,GPIO.OUT)
	GPIO.output(17,GPIO.LOW)
	time.sleep(15)
	GPIO.output(17,GPIO.HIGH)
	time.sleep(1)
	GPIO.cleanup()

def closeActuator():
	GPIO.setmode(GPIO.BCM)
	GPIO.setup(27,GPIO.OUT)
	GPIO.output(27,GPIO.LOW)
	time.sleep(15)
	GPIO.output(27,GPIO.HIGH)
	time.sleep(1)
	GPIO.cleanup()	

def openActuatorB():

	GPIO.setmode(GPIO.BCM)
	GPIO.setup(22,GPIO.OUT)
	GPIO.output(22,GPIO.LOW)
	time.sleep(15)
	GPIO.output(22,GPIO.HIGH)
	time.sleep(1)
	GPIO.cleanup()

def closeActuatorB():

	GPIO.setmode(GPIO.BCM)
	GPIO.setup(24,GPIO.OUT)
	GPIO.output(24,GPIO.LOW)
	time.sleep(15)
	GPIO.output(24,GPIO.HIGH)
	time.sleep(1)
	GPIO.cleanup()

def ignitionSequence():

	GPIO.setmode(GPIO.BCM)

	GPIO.setup(25,GPIO.OUT) #Igniters
	# GPIO.setup(16,GPIO.OUT)	#Nichrome Wire
	GPIO.setup(27,GPIO.OUT) #Actuator A

	time.sleep(2) # To sync with countdown (update for last static fire)
	GPIO.output(27,GPIO.LOW)  #Closes Actuator A t = 0
	time.sleep(8)
	# time.sleep(3)
	# GPIO.output(16,GPIO.HIGH) #Sends charge to Nichrome time elapsed: 3/s
	# time.sleep(2)
	GPIO.output(25,GPIO.HIGH) #Sends charge to Igniters time elapsed: 5/s
	time.sleep(3)
	GPIO.output(25,GPIO.LOW) #Shutsdown Igniters and t+3/s relative to Igniters
	time.sleep(5)
	# GPIO.output(16,GPIO.LOW) #Shutsdown Nichrome wire after t+15/s relative to Nichrome
	GPIO.output(27,GPIO.HIGH) #Shutsdown Actuator A


	GPIO.cleanup()

def loadCellThread():

	try:
		_thread.start_new_thread( loadCellData, ("Thread-1",))
	except Exception as e:
		print(e)

def loadCellData(s):

	ser = serial.Serial('/dev/ttyACM0',9600,timeout=1)
	ser.flush()
	s = socket.socket()
	port = 8894 # Possible conflictions
	s.bind(('',port))
	s.listen(5)
	c,addr = s.accept()
	print("Load Cell Connected to Launch Station")
	while True:
		if ser.in_waiting > 0:
			line = ser.readline().decode('utf-8').rstrip()
			print(line)
			time.sleep(.5)
	
	
def openSocket():

	s = socket.socket()

	port = 8893

	s.bind(('',port))

	s.listen(5)

	c,addr = s.accept()

	print("Connection to Launch Station")

	try:

		while True:

			r = c.recv(1024).decode()
			print("S:",r)
			
			if r == 'ao':
				openActuator()
			elif r == 'ac':
				closeActuator()
			elif r == 'bo':
				openActuatorB()
			elif r == 'bc':
				closeActuatorB()
			elif r == 'ig':
				ignitionSequence()
			elif r == 'lc':
				loadCellThread()

	except KeyboardInterrupt:
		print('Keyboard Intiated ShutDown')
		s.shutdown(SHUT_RDWR)
		s.close()
		c.close()


def ShutDown():

	try:
		sys.exit(0)

	except SystemExit:
		os._exit(0)



def main():

	try:
		openSocket()

	except KeyboardInterrupt:
		print('Keyboard Intiated ShutDown')
		ShutDown()


if __name__ == "__main__":
	main()
