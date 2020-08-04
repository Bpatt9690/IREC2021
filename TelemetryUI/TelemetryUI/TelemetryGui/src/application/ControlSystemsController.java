package application;

import com.sun.prism.paint.Color;

import Interface.AbortLaunchObjectEvent;
import Interface.AltStreamObject;
import Interface.ArmRocketObjectEvent;
import Interface.BackGroundController;
import Interface.BackGroundInterface;
import Interface.FillValveClosedObjectEvent;
import Interface.FillValveOpenObjectEvent;
import Interface.LaunchRocketObjectEvent;
import Interface.PurgeValveClosedObjectEvent;
import Interface.PurgeValveObjectEvent;
import Interface.StartAltObjectEvenet;
import Interface.StartGraphObjectEvent;
import Interface.StartOrientationObjectEvent;
import Interface.StartPressureObjectEvent;
import Interface.StopAltObjectEvent;
import Interface.StopGraphObjectEvent;
import Interface.StopOrientationObjectEvent;
import Interface.StopPressureObjectEvent;
import Network.LoRaNetwork;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class ControlSystemsController implements BackGroundInterface {
	
	BackGroundController controller = null;
	LoRaNetwork LoRaNet = null;
	
	private boolean abortLaunch = false;
	
	private String rfIP = null;
	private String gseIP = null;
	
	@FXML
	private Button ipEnterButton;
	@FXML
	private Button ipClearButton;
	@FXML
	private Button startAltButton;
	@FXML
	private Button stopAltButton;
	@FXML
	private Button startOrientationButton;
	@FXML
	private Button stopOrientationButton;
	@FXML
	private Button startPressureButton;
	@FXML
	private Button stopPressureButton;
	@FXML
	private Button startGraphButton;
	@FXML
	private Button stopGraphButton;
	@FXML
	private Button fillValveOpen;
	@FXML
	private Button fillValveClosed;
	@FXML
	private Label altDataStatus;
	@FXML 
	private Label orientationLabel;
	@FXML 
	private Label pressureLabel;
	@FXML 
	private Label graphLabel;
	@FXML
	private Label fillValveLabel;
	@FXML
	private Label purgeValveLabel;
	@FXML
	private Label camera1Label;
	@FXML
	private Label camera2Label;
	@FXML
	private TextField rfIPField;
	@FXML
	private TextField gseIPField;
	@FXML
	private Label ipErrorLabel;
	
	
	public void setController(BackGroundController controller) {
		this.controller = controller;
	}
	
	@FXML
	private void altDataGo() {
		if(isSet()) {
		altDataStatus.setStyle("-fx-background-color: green;-fx-background-radius:10");
		controller.startAltStream();
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
		
	}
	
	@FXML
	private void altDataStop() {
		if(isSet()) {
		altDataStatus.setStyle("-fx-background-color: red;-fx-background-radius:10");
		controller.stopAlt();
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
		
	}
	
	@FXML
	private void orientationStart() {
		if(isSet()) {
		orientationLabel.setStyle("-fx-background-color: green;-fx-background-radius:10");
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	
	@FXML
	private void orientationStop() {
		if(isSet()) {
		orientationLabel.setStyle("-fx-background-color: red;-fx-background-radius:10");
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	
	@FXML
	private void pressureStart() {
		if(isSet()) {
		pressureLabel.setStyle("-fx-background-color: green;-fx-background-radius:10");
		controller.startPressure("null");
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
		
	}
	
	@FXML
	private void pressureStop() {
		if(isSet()) {
		pressureLabel.setStyle("-fx-background-color: red;-fx-background-radius:10");
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	
	@FXML
	private void graphStart() {
		if(isSet()) {
		graphLabel.setStyle("-fx-background-color: green;-fx-background-radius:10");
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	
	@FXML
	private void graphStop() {
		if(isSet()) {
			graphLabel.setStyle("-fx-background-color: red;-fx-background-radius:10");
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	
	
	
	@FXML
	private void openFillValve() {
		if(isSet()) {
			fillValveLabel.setStyle("-fx-background-color: green;-fx-background-radius:10");
			controller.fillValveOpen();
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
		
	}
	
	@FXML
	private void closeFillValve() {
		if(isSet()) {
			fillValveLabel.setStyle("-fx-background-color: red;-fx-background-radius:10");
			controller.fillValveClosed();
		}
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
		
	}
	
	@FXML
	private void openPurgeValve() {
		if(isSet())
			purgeValveLabel.setStyle("-fx-background-color: green; -fx-background-radius:10");
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	
	@FXML
	private void closePurgeValve() {
		if(isSet())
			purgeValveLabel.setStyle("-fx-background-color: red; -fx-background-radius:10");
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	@FXML
	private void camera1On() {
		if(isSet())
			camera1Label.setStyle("-fx-background-color: green; -fx-background-radius:10");
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	@FXML
	private void camera1Off() {
		if(isSet())
			camera1Label.setStyle("-fx-background-color: red; -fx-background-radius: 10");
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	@FXML
	private void camera2On() {
		if(isSet())
			camera2Label.setStyle("-fx-background-color: green; -fx-background-radius: 10");
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	@FXML
	private void camera2Off() {
		if(isSet())
			camera2Label.setStyle("-fx-background-color: red; -fx-background-radius: 10");
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	
	@FXML
	private void armRocket() {
		if(isSet())
			controller.armRocket();
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
		
	}

	@FXML
	private void abortLaunch() {
		if(isSet())
			controller.abortLaunch();
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
	}
	
	@FXML
	private void launchRocket() {
		if(isSet())
			controller.launchRocket();
		
		else 
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
	}
	
	@FXML
	private void getIPFields() {
		
		this.gseIP = gseIPField.getText();
		this.rfIP = rfIPField.getText();
		
		if(!(gseIP.isEmpty()) | !(rfIP.isEmpty())) {
		
		
		ipErrorLabel.setTextFill(Paint.valueOf("#000000"));
		
		LoRaNet = new LoRaNetwork(rfIP,8082,controller);
		LoRaNet.setDaemon(true);
		LoRaNet.start();
		controller.addInstallListener(LoRaNet);
		}
		
		else {
			ipErrorLabel.setTextFill(Paint.valueOf("#ff0000"));
			ipErrorLabel.setText("Error: Must Set IP First");
		}
		
	}
	
	@FXML
	private void clearIPFields() {
		rfIPField.setText("");
		gseIPField.setText("");
	}

	
	public boolean isSet() {
		if(rfIP == null | gseIP == null) 
			return false;
		
		else
			return true;
	}
	
	@Override
	public void armRocket(ArmRocketObjectEvent e) {
		
	}

	@Override
	public void abortLaunch(AbortLaunchObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void launchRocket(LaunchRocketObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startAlt(StartAltObjectEvenet e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopAlt(StopAltObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startOrientation(StartOrientationObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopOrienatation(StopOrientationObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPressure(StartPressureObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopPressure(StopPressureObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startGraph(StartGraphObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopGraph(StopGraphObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillValveOpen(FillValveOpenObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillValveClosed(FillValveClosedObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void purgeValveOpen(PurgeValveObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void purgeValveClosed(PurgeValveClosedObjectEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startAltStream(AltStreamObject e) {
		// TODO Auto-generated method stub
		
	}
	
}
