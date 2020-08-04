package application;

import java.awt.Color;

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
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.util.*;

public class TelemetryScreenController implements BackGroundInterface{

	BackGroundController controller = null;
	
	@FXML
	private Label telemetryStatus; // change this based on thread health
	@FXML
	private Label rssiLabel; // change based on current RSSI
	@FXML
	private Pane altPane;
	@FXML
	private Label portStatus;
	@FXML
	private TextArea altTextArea;
	@FXML
	private TextArea pressureTextArea;
	@FXML
	private TextArea orientationTextArea;
	@FXML
	private TextArea graphTextArea;
	
	private StringBuilder altString = null;
	
	public void setController(BackGroundController controller) {

		altString = new StringBuilder();
		
		this.controller = controller;
		
		graphTextArea.setEditable(false);
		graphTextArea.setStyle("-fx-control-inner-background:#000000; -fx-font-family: System; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");
		
		pressureTextArea.setEditable(false);
		pressureTextArea.setStyle("-fx-control-inner-background:#000000; -fx-font-family: System; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");
		
		orientationTextArea.setEditable(false);
		orientationTextArea.setStyle("-fx-control-inner-background:#000000; -fx-font-family: System; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");
		
		altTextArea.setEditable(false);
		altTextArea.setStyle("-fx-control-inner-background:#000000; -fx-font-family: System; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");
	}
	
	
	public void displayAltData(String data) {

		altTextArea.appendText(data);
	
	}
	
	public void displayPressureData(String data) {
		pressureTextArea.appendText("9.25\n");
		
	}
	
	public void displayGraphData() {
		//work this out
		
	}
	
	public void displayOrientationData() {
		//work this out as well
	}
	
	@FXML
	public void telemetryStatusNominal() {
		//telemetryStatusLabel.setStyle("-fx-background-color: red;");
	
	}
	@FXML
	public void telemetryStatusOffline() {
		//telemetryStatusLabel.setStyle("-fx-background-color: red;");
		
	}
	
	@FXML
	private void setRSSI() {
		
	}
	
	public void altitudePaneData() {
		
	}
	
	@FXML
	private void setPortStatusConnected() {
		
	}
	
	@FXML
	private void setPortStatusDisconnected() {
		
	}
	@Override
	public void armRocket(ArmRocketObjectEvent e) {
		// TODO Auto-generated method stub
		
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
		displayAltData(data);
		
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
		displayPressureData(data);
		
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
