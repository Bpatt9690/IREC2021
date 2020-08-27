import socket
import time

s = socket.socket()

print('Socket created')

port = 883

host = socket.gethostname()

print(host)

s.bind(('',port))

print('Socket binded to %s' %(port))

s.listen(5)

print("listening")

message = "bbby"

c, addr = s.accept()

print("got connection from", addr)

while True:
	c.sendall(message.encode('utf-8'))
	time.sleep(2)
	
c.close()
