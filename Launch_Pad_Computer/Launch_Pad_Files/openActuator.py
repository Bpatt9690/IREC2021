import RPi.GPIO as GPIO

import time

GPIO.setmode(GPIO.BCM)

GPIO.setup(3,GPIO.OUT)

GPIO.output(3,GPIO.HIGH)
time.sleep(10)


