import board
import busio
import time
import adafruit_bmp280
import adafruit_bno055
import RPi.GPIO as GPIO
import adafruit_ssd1306
import adafruit_rfm9x
from digitalio import DigitalInOut, Direction, Pull

#Sensor Configs
i2c = busio.I2C(board.SCL, board.SDA)
tempSensor = adafruit_bmp280.Adafruit_BMP280_I2C(i2c)
orientationSensor = adafruit_bno055.BNO055_I2C(i2c)
CS = DigitalInOut(board.CE1)
RESET = DigitalInOut(board.D25)
spi = busio.SPI(board.SCK, MOSI=board.MOSI, MISO=board.MISO)
rfm9x = adafruit_rfm9x.RFM9x(spi,CS,RESET,915.0)
rfm9x.tx_power = 23 


#Packet
prev_packet = None
data = bytes('data',"utf-8")

while True:
    
        try:
            print('RFM9x: Detected')
            rfm9x.send(data)
            time.sleep(5)

        except RuntimeError as error:
            print('RFM9x Error: ', error)
  
        time.sleep(3)


#Misc


#print('Temperature: {:.2f} degrees C'.format(tempSensor.temperature)) 
#print('Pressure: {:.2f}hPa'.format(tempSensor.pressure))
#print()
#print("Accelerometer Data:")



#time.sleep(10)
#GPIO.setmode(GPIO.BCM)
#GPIO.setup(4,GPIO.OUT)
#print("sending signal")
#GPIO.output(4,GPIO.HIGH)
#time.sleep(10)
#GPIO.output(4,GPIO.LOW)
#time.sleep(10)
#GPIO.cleanup()


#while True:
    #print("Temperature: {} degrees C".format(orientationSensor.temperature))
    #print("{}".format(orientationSensor.acceleration))
    #print("Magnetometer (microteslas): {}".format(orientationSensor.magnetic))
    #print("Gyroscope (rad/sec): {}".format(orientationSensor.gyro))
    #print("Euler angle: {}".format(orientationSensor.euler))
    #print("Quaternion: {}".format(orientationSensor.quaternion))
    #print("Linear acceleration (m/s^2): {}".format(orientationSensor.linear_acceleration))
    #print("Gravity (m/s^2): {}".format(orientationSensor.gravity))
    #print()
 
    #time.sleep(.5)