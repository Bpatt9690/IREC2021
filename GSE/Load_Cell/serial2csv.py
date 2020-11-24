#!/user/bin/env python
import serial
import csv
import os
import times
port = '/dev/ttyACM0'

ser = serial.Serial(port, 9600)
ser.flushInput()

with open('ColdFlowTest5.csv', mode="w") as csv_file:
    csv_writer = csv.writer(csv_file, delimiter=",", quotechar='"', quoting=csv.QUOTE_MINIMAL)
    # csv_writer.writerow("[ColdFlowTest5]")
    while True:
        data_raw = ser.readline()

        try:
            seconds, pounds, newtons, psi, celcius_nox, celcius_cc = data_raw.decode("utf-8").rstrip().split(",")
            print(seconds, pounds, newtons, psi, celcius_nox, celcius_cc)
            csv_writer.writerow([seconds, pounds, newtons, psi, celcius_nox, celcius_cc])
            csv_file.flush()
            os.fsync(csv_file.fileno())
            print("written to file")

        except:
            pass