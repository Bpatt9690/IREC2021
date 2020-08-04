import socket
import sys
import time


s = socket.socket()

port = 8082

s.bind(('',port))

s.listen(5)

while True:
	c, addr = s.accept()

	print("Got connection from", addr)

	st ="98873\n"

	byt = st.encode()

	while True:
		print(str(byt))
		c.send(byt)
		time.sleep(1)


