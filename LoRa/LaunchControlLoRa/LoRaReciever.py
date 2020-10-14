import time
import busio
from digitalio import DigitalInOut, Direction, Pull
import board
import adafruit_ssd1306
import adafruit_rfm9x
import sys
import datetime

MyDateTime = datetime.datetime(2016,1,3,8,30,20)
  
i2c = busio.I2C(board.SCL, board.SDA)
 
reset_pin = DigitalInOut(board.D4)
display = adafruit_ssd1306.SSD1306_I2C(128, 32, i2c, reset=reset_pin)
# Clear the display.
display.fill(0)
display.show()
width = display.width
height = display.height
 
# Configure LoRa Radio
CS = DigitalInOut(board.CE1)
RESET = DigitalInOut(board.D25)
spi = busio.SPI(board.SCK, MOSI=board.MOSI, MISO=board.MISO)
rfm9x = adafruit_rfm9x.RFM9x(spi, CS, RESET, 915.0,preamble_length = 8, high_power=True,baudrate=5000000)
rfm9x.tx_power = 23
prev_packet = None

#Logs
dataLog = open("/home/pi/Dev/dataLog.txt","a")
errorLog = open("/home/pi/Dev/errorLog.txt","a")
transmissionLog = open("/home/pi/Dev/transmissionLog.txt","a")

eotCommand = "End of Transmission\r\n"
packetNumber = 0

while True:
    packet = None
    display.fill(0)
    display.text('Waiting For Incoming', 5, 0, 1)
    display.text(' Transmission ', 13, 20, 1)

    try:
        packet = rfm9x.receive()

        if packet is None:
            display.show()
            
        else:
        # Display packet and log the data
            display.fill(0)
            prev_packet = packet
            rssiValue = str(rfm9x.rssi)
            packet_text = str(prev_packet, "utf-8")
            rssiValue =  str(rssiValue)        
            packetNumber = packetNumber + 1
            #dataLog.write(str(rssiValue))
            #dataLog.write(datetime.datetime.now().strftime("%H:%M:%S\n"))
            #dataLog.write("{0}".format(packet_text))
            #dataLog.write("Packet Number: {0}\n".format(packetNumber))
            display.text(rssiValue, 0, 0, 1)
            display.show()
            print(packet_text)

    except Exception as e:
        errorLog.write(str(e))
        dataLog.close()
        errorLog.close()
        transmissionLog.close()
        display.fill(0)
        display.show()
        
    except KeyboardInterrupt as e:
        dataLog.close()
        errorLog.close()
        transmissionLog.close()
        display.fill(0)
        display.show()
        sys.exit()

