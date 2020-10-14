import board
import busio
import time
import adafruit_bmp280
import adafruit_bno055
import RPi.GPIO as GPIO
import adafruit_ssd1306
import adafruit_rfm9x
import os
import queue
import decimal
import _thread
import threading
from digitalio import DigitalInOut, Direction, Pull

DataQueue = queue.Queue()

try:
    i2c = busio.I2C(board.SCL, board.SDA)
    bmpSensor = adafruit_bmp280.Adafruit_BMP280_I2C(i2c)
    orientationSensor = adafruit_bno055.BNO055_I2C(i2c)
    CS = DigitalInOut(board.CE1)
    RESET = DigitalInOut(board.D25)
    spi = busio.SPI(board.SCK, MOSI=board.MOSI, MISO=board.MISO)
    rfm9x = adafruit_rfm9x.RFM9x(spi,CS,RESET,915.0)
    rfm9x.tx_power = 23 
    print('RFM9x: Detected') # Inform UI

except RuntimeError as error:
    print('Sensor error: '+error) #Inform UI


def OpenAmplifier():

    GPIO.setmode(GPIO.BCM)
    GPIO.setup(4,GPIO.OUT)
    GPIO.output(4,GPIO.HIGH)
    time.sleep(10) # used for testing w
    GPIO.output(4,GPIO.LOW)

def CloseAmplifier():
    #GPIO to close circuit
    print('Close Amplifier')
    

def DataTransmission():

        global DataQueue

        if DataQueue.empty() is True:
            return

        if DataQueue.empty() is False:

            try:
                data = bytes(DataQueue.get(0),"utf-8")
                rfm9x.send(data)

            except RuntimeError as error:
                print('RFM9x error:'+ error)


class DataAcquisition(threading.Thread):

    def __init__(self,ThreadID,name,DataQueue,orientationSensor,bmpSensor):
        threading.Thread.__init__(self)
        self.ThreadID = ThreadID
        self.name = name
        self.DataQueue = DataQueue
        self.orientationSensor = orientationSensor 
        self.bmpSensor = bmpSensor
        self.FormattedData = str()
    

    def run(self):

        print('Starting '+self.name)

        def DataFiltering():

            print('in data filtering')
            #Implement a Low Pass Filter and remove uneeded decimals and values

        def TupleFormatting(data):

            if any(map(lambda ele: ele is None, data)) is False:
                Data = str(','.join(format(f,'.2f') for f in data))
                return Data    

            else:
                Data = "null" 
                return Data

        def IntegerFormatting(data):
            Data = str('{0:.1f}'.format(data))
            return Data

        def FloatFormatting(data):
            Data = str('{0:.1f}'.format(data))
            return Data

        while True:

            FormattedData = "|"
 
            try:

                temp = self.orientationSensor.temperature
                orientation = self.orientationSensor.acceleration
                gyro = self.orientationSensor.gyro
                linear = self.orientationSensor.linear_acceleration
                pressure = self.bmpSensor.pressure
                alt = self.bmpSensor.altitude

                SensorList = [temp,orientation,gyro,linear,pressure,alt]

                for sensor in SensorList:
              
                    if isinstance(sensor,tuple):
                        FormattedData += TupleFormatting(sensor)+"|"

                    elif isinstance(sensor,int):
                        FormattedData += IntegerFormatting(sensor)+"|"

                    elif isinstance(sensor,float):
                        FormattedData += FloatFormatting(sensor)+"|"
                      
              
                self.DataQueue.put(FormattedData)
                print(list(self.DataQueue.queue));
              


            except RuntimeError as error:
                print(error)

            time.sleep(.1)

def ShutDown():

    try:
        GPIO.cleanup()
        os._exit(0)

    except SystemExit:
        os._exit(0)
        

def main():

    global orientationSensor
    global bmpSensor
    global DataQueue

    try:
        thread = DataAcquisition('DataAcquisition Thread','Data',DataQueue,orientationSensor,bmpSensor)
        thread.start()

    except RuntimeError as error:
        print(error)

    while 1:
        DataTransmission()
        time.sleep(.5)

if __name__ == "__main__":

    try:
        main()

    except KeyboardInterrupt:
        print("Keyboard Interrupted")
        ShutDown()
        



