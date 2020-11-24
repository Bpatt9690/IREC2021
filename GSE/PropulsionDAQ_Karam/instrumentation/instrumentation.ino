/*
 UCF IREC 2020 - PROPULSION TEAM 
 FILE NAME:      LOAD_CELL_AND_PRESSURE_TRANSDUCER 
 Date:           Oct 5th, 2020
 AUTHOR:         ETHAN SHERLOCK, KARAM PAUL, SAMER ARMALY 
 REVISION:       4
 
 LOADCELL:
 HX711 Library: https://github.com/bogde/HX711
 The HX711 does one thing well: read load cells
 Arduino pin 2 -> HX711 CLK
 3 -> DAT
 5V -> VCC
 GND -> GND

 Pressure Transducer:
 5V, Ground, Analog Pin (A0)
 
*/

#include "HX711.h"
//#include <SD.h>
#include <SPI.h>
#include "Wire.h" 

#define calibration_factor -4010 // -4010 for S-Type

#define DOUT  3
#define CLK  2

float start_time;
float current_time;
float measurement_pounds;
float measurement_newtons;
HX711 scale;

const int pressureInput = A0; // analog  pin for the first pressure transducer
const int temperatureInput1 = A1; // analog pin for temperature sensor
const int temperatureInput2 = A2; // analog  pin for the second pressure transducer
const int pressureZero = 102; //analog reading of pressure transducer at 0psi
const int pressureMax = 922; //analog reading of pressure transducer at 100psi
const int transducerMax = 2500; //psi value of transducer being used
double pressure = 0; //variable to store the value coming from the first pressure transducer

double temperature1 = 0; //variable to store the value coming from the first temperature sensor
double temperature2 = 0; //variable to store the value coming from the second temperature sensor

// File output;

void setup() {
  Serial.begin(9600);

//  // Set up SD card
//  Serial.println("Initializing SD Card...");
//  pinMode(10,OUTPUT);
//  while (!SD.begin(4)) {
//    Serial.println("Initialization Failed!");
//    delay(1000);
//  }
//  Serial.println("Initialization Done.");
//  Serial.print("\n");
  
  //Open the file, write initialization statement, close the file
//  output = SD.open("data.txt", FILE_WRITE);
//  output.println("\n");
//  output.println("seconds, pounds, newtons, pressure");
//  output.close();

  // Start clock
  start_time = millis();

  // Initialize load cell and confirm in serial
  Serial.println("HX711 scale demo");
  scale.begin(DOUT, CLK);
  scale.set_scale(calibration_factor); //This value is obtained by using the HX711_Calibration sketch
  scale.tare(); //Assuming there is no weight on the scale at start up, reset the scale to 0
  Serial.println("Beginning Load Cell Data Acquisition...");
}

void loop() {
  // Record current time 
  current_time = millis();
  current_time = current_time / 1000 ;

  // Open the file. Files will not be overwritten if the filename is recognized. 
//  output = SD.open("data.txt", FILE_WRITE);

  // Collect loadcell data and assign it units (pounds and newtons)
  measurement_pounds = (scale.get_units());
  measurement_newtons = 4.448 * measurement_pounds;

  // Collect transducer data and assign it a unit (psi)
  pressure = analogRead(pressureInput);
  pressure = (( (pressure - pressureZero) / (pressureMax - pressureZero) ) * transducerMax); 

  // Collect temperature sensor data, assign it a unit (C) and control its bounds (rated for -40 to 125)
  int temp_reading1 = analogRead(temperatureInput1);
  temperature1 = temp_reading1 * 5;
  temperature1 /= 1024; 
  temperature1 = (temperature1 - 0.5) * 100;

  int temp_reading2 = analogRead(temperatureInput2);
  temperature2 = temp_reading2 * 5;
  temperature2 /= 1024; 
  temperature2 = (temperature2 - 0.5) * 100;
  
  
  // temperature = constrain(temperature,-40,125);

  //Print the data to the serial monitor
//  Serial.print(current_time , 3);
//  Serial.print(" seconds , ");
//  Serial.print(measurement_pounds, 3);
//  Serial.print(" pounds , ");
//  Serial.print(measurement_newtons, 3);
//  Serial.print(" newtons , ");
//  Serial.print(pressure, 3);
//  Serial.print(" psi , ");
//  Serial.println();

  Serial.print(current_time , 3);
  Serial.print(" , ");
  Serial.print(measurement_pounds, 3);
  Serial.print(" , ");
  Serial.print(measurement_newtons, 3);
  Serial.print(" , ");
  Serial.print(pressure, 3);
  Serial.print(" , ");
  Serial.print(temperature1, 3);
  Serial.print(" , ");
  Serial.print(temperature2, 3);
  Serial.println();

  //Output to SD card and close the file
//  output.print(current_time, 3);
//  output.print(" , ");
//  output.print(measurement_pounds, 3);
//  output.print(" , ");
//  output.print(measurement_newtons, 3);
//  output.print(" , "); 
//  output.print(pressure, 3); 
//  output.println();
//  output.close();

}
