import socket
import sys
import time


def main():

	fillCommand = "fillOpen"

	closeCommand = 'fillClose'

	print(fillCommand)

	s = socket.socket()

	port = 8083

	s.bind(('',port))

	s.listen(5)

	while True:
		c, addr = s.accept()

		print("Got connection from", addr)

		while True:
			s = c.recv(1024)

			command = s.decode('UTF-8')

			command = command.replace(' ','')

			command = command.replace('\t','')

			print(command)
			print(fillCommand == command)

			if s == fillCommand:
				openFillValve()

			time.sleep(1)


def openFillValve():
	print("in fill funciton all we need is gpio")

def closeFillValve():
	print("inclose function")



if __name__ == "__main__":
	main()

