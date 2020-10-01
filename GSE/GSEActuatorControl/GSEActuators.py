import socket
import RPi.GPIO as GPIO
import time

def openActuator():
	GPIO.setmode(GPIO.BCM)
	GPIO.setup(17,GPIO.OUT)
	GPIO.output(17,GPIO.LOW)
	time.sleep(10)
	GPIO.output(17,GPIO.HIGH)
	time.sleep(1)
	GPIO.cleanup()

def closeActuator():
	GPIO.setmode(GPIO.BCM)
	GPIO.setup(27,GPIO.OUT)
	GPIO.output(27,GPIO.LOW)
	time.sleep(10)
	GPIO.output(27,GPIO.HIGH)
	time.sleep(1)
	GPIO.cleanup()	

def openActuatorB():
	GPIO.setmode(GPIO.BCM)
	GPIO.setup(22,GPIO.OUT)
	GPIO.output(22,GPIO.LOW)
	time.sleep(10)
	GPIO.output(22,GPIO.HIGH)
	time.sleep(1)
	GPIO.cleanup()

def closeActuatorB():
	GPIO.setmode(GPIO.BCM)
	GPIO.setup(23,GPIO.OUT)
	GPIO.output(23,GPIO.LOW)
	time.sleep(10)
	GPIO.output(23,GPIO.HIGH)
	time.sleep(1)
	GPIO.cleanup()

def ignitionSequence():
	GPIO.setmode(GPIO.BCM)
	GPIO.setup(25,GPIO.OUT)
	GPIO.output(25,GPIO.HIGH)
	time.sleep(5)
	GPIO.cleanup()

def openSocket():
	s = socket.socket()

	port = 8893

	s.bind(('',port))

	s.listen(5)

	c,addr = s.accept()

	print("Connection to Launch Station")

	#GPIO.cleanup()

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
		elif t == 'ig':
			ignitionSequence()

	c.close()


def main():
	openSocket()

if __name__ == "__main__":
	main()
