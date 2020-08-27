import RPI.GPIO as GPIO

from time import sleep

GPIO.setmod(GPIO.BCM)

GPIO.setwarning(False)


OutputPins = [22,23,24,25]

for i in OutputPins:
	GPIO.setup(i, GPIO.OUT
	GPIO.output(i, False)

try:
	while(True):
		for i in OputPins:
			GPIO.output(i, True)
			sleep(5)
			GPIO.output(i,False)


except KeyboardInterrupt:
	for i in OutPins:
		GPIO.output(i, False)
