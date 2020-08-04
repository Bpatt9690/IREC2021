package application;

import java.net.*;
import java.io.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

import com.sun.javafx.geom.Rectangle;
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
import javafx.event.ActionEvent;
import java.util.concurrent.*;

public class LaunchPadSystemsController implements BackGroundInterface {
	
	BackGroundController controller = null;
	
	private boolean abortLaunch = false;
	
	private boolean launch = false;
	
	private String cameraPort1 = null;
	private String cameraPort2 = null;
	
	@FXML
	private TextField cameraPort1Field;
	
	@FXML
	private TextField cameraPort2Field;
	
	@FXML
	private Button cameraPortEnter;
	
	@FXML 
	private Button cameraPortClear;
	
	@FXML
	private  Polygon sol1;
	
	@FXML
	private AnchorPane camera1Feed; 
	
	@FXML
	private  Line centerFillLine;
		
	@FXML
	private Line fillLineA;
	
	@FXML
	private Line fillLineB;
	
	@FXML
	private Line fillLineC;
	
	@FXML
	private Line fillLineD;
	
	@FXML
	private Line fillLineE;
	
	@FXML
	private Line fillLineF;
	
	@FXML
	private Line ignitionLineA;
	
	@FXML
	private Line ignitionLineB;
	
	@FXML
	private Line ignitionLineC;
	
	@FXML
	private Line ignitionLineD;

	public void setController(BackGroundController controller) {
		this.controller = controller;
	}
	
	@FXML
	private boolean cameraPortStatus() {
		if(cameraPort1.isEmpty() | cameraPort2.isEmpty())
			return false;
		
		else if(!(cameraPort1.isEmpty()) & !(cameraPort2.isEmpty()))
			return true;
		
		else 
			return false;
	}
	
	@FXML
	private void setCameraPortFields(ActionEvent e) {	
		this.cameraPort1 = cameraPort1Field.getText();
		this.cameraPort2 = cameraPort2Field.getText();
		
	}
	

	@FXML 
	public void resetCameraPortFields(){

		cameraPort1Field.setText("");
		cameraPort2Field.setText("");
	}
	
	public void setFillLineOn() {	
		centerFillLine.setStroke(Paint.valueOf("008000"));
		fillLineA.setStroke(Paint.valueOf("008000"));
		fillLineB.setStroke(Paint.valueOf("008000"));
		fillLineC.setStroke(Paint.valueOf("008000"));
		fillLineD.setStroke(Paint.valueOf("008000"));
		fillLineE.setStroke(Paint.valueOf("008000"));
		fillLineF.setStroke(Paint.valueOf("008000"));

	}
	
	
	public void setFillLineOff() {
		centerFillLine.setStroke(Paint.valueOf("ff0000"));
		fillLineA.setStroke(Paint.valueOf("ff0000"));
		fillLineB.setStroke(Paint.valueOf("ff0000"));
		fillLineC.setStroke(Paint.valueOf("ff0000"));
		fillLineD.setStroke(Paint.valueOf("ff0000"));
		fillLineE.setStroke(Paint.valueOf("ff0000"));
		fillLineF.setStroke(Paint.valueOf("ff0000"));
	}

	
	
	
	public void setIgnitionLineOn() {
		ignitionLineA.setStroke(Paint.valueOf("008000"));
		ignitionLineB.setStroke(Paint.valueOf("008000"));
		ignitionLineC.setStroke(Paint.valueOf("008000"));
		ignitionLineD.setStroke(Paint.valueOf("008000"));
		
	}
	
	public void setArmIgnitionLine() {
		

			ignitionLineA.setStroke(Paint.valueOf("ffff00"));
			ignitionLineB.setStroke(Paint.valueOf("ffff00"));
			ignitionLineC.setStroke(Paint.valueOf("ffff00"));
			ignitionLineD.setStroke(Paint.valueOf("ffff00"));

		
	}
	
	public void setIgnitionLineOff() {
		ignitionLineA.setStroke(Paint.valueOf("ff0000"));
		ignitionLineB.setStroke(Paint.valueOf("ff0000"));
		ignitionLineC.setStroke(Paint.valueOf("ff0000"));
		ignitionLineD.setStroke(Paint.valueOf("ff0000"));
		
	}
	
	
	public void camera1On() {
	
		
	}
	

	public void setWifiStrength() {
		
	}

	@Override
	public void armRocket(ArmRocketObjectEvent e) {
		// TODO Auto-generated method stub
		setArmIgnitionLine();
	}

	@Override
	public void abortLaunch(AbortLaunchObjectEvent e) {
		// TODO Auto-generated method stub
		setIgnitionLineOff();
		
	}

	@Override
	public void launchRocket(LaunchRocketObjectEvent e) {
		// TODO Auto-generated method stub
		setIgnitionLineOn();
		
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
		setFillLineOn();
		
	}

	@Override
	public void fillValveClosed(FillValveClosedObjectEvent e) {
		// TODO Auto-generated method stub
		setFillLineOff();
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
