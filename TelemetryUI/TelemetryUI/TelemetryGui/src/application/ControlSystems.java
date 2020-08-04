package application;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import Interface.AbortLaunchObjectEvent;
import Interface.ArmRocketObjectEvent;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControlSystems implements Runnable {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] devices = env.getScreenDevices();
	public double height = screenSize.getHeight();
	public double width = screenSize.getWidth();
	ControlSystemsController sysControl = null;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ControlSystemsXML.fxml"));
			Parent root = loader.load();
			Stage primaryStage = new Stage();
	        primaryStage.setTitle("Systems Control Panel");
	        primaryStage.setScene(new Scene(root, width, height));
	        primaryStage.show();
	        sysControl = loader.getController();
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
		
		
	}
	
	public void setScreenSize(double height, double width) {
		this.height = height;
		this.width = width;
	}
	

		public ControlSystemsController getSysController() {
			return sysControl;
		}
}
