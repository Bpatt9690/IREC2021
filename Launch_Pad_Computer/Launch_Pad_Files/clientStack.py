import socket
import RPi.GPIO as GPIO
import time

#parser to input port

def openActuator():
	GPIO.setmode(GPIO.BCM)

	GPIO.setup(3,GPIO.OUT)

	GPIO.output(3,GPIO.HIGH)
	time.sleep(10)

def closeActuator():
	GPIO.setmode(GPIO.BCM)

	GPIO.setup(3,GPIO.OUT)

	GPIO.output(3,GPIO.LOW)
	time.sleep(10)


def openSocket():
	s = socket.socket()

	port = 8893

	s.bind(('',port))

	s.listen(5)

	c,addr = s.accept()

	print("Up and running")

	while True:

		r = c.recv(1024).decode()
		print("S:",r)
		
		if r == 'ao':
			openActuator()
		elif r == 'ac':
			closeActuator()

	c.close()


def main():
	openSocket()

if __name__ == "__main__":
	main()
