import serial
import os
import time
import socket

def openPort():
	s = socket.socket()
	port = 8894 # Possible conflictions
	s.bind(('',port))
	s.listen(5)
	c,addr = s.accept()
	print("Load Cell Connected to Launch Station")
	transmitData()

def transmitData():
	while True:
	if ser.in_waiting > 0:
		line = ser.readline().decode('utf-8').rstrip()
		print(line)
		time.sleep(.5)
	
def main():
	ser = serial.Serial('/dev/ttyACM0',9600,timeout=1)
	ser.flush()
	openPort()

if __name__ == '__main__':
	main()


