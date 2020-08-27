import socket
import time

host = ''
port = 8830

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:

	s.bind((host,port))
	s.listen()
	conn,addr = s.accept()

	with conn:
		print('Connect by:',addr)

		while True:
			print('inside')
			data = conn.recv(10)
			time.sleep(2)
			
			print(data)

			if data.decode('utf-8') == 'tits':
				print("flucker")