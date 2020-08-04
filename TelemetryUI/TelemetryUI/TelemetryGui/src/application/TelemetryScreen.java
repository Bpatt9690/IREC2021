package application;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelemetryScreen implements Runnable {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] devices = env.getScreenDevices();
	public double height = screenSize.getHeight();
	public double width = screenSize.getWidth();
	TelemetryScreenController telemetryController = null;
	
	@Override
	public void run() {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("TelemetryXML.fxml"));
			Parent root = loader.load();
			Stage primaryStage = new Stage();
	        primaryStage.setTitle("UCF IREC SEDS/AIAA Telemetry");
	        primaryStage.setScene(new Scene(root, width, height));
	        primaryStage.show();
	        telemetryController = loader.getController();
	
	        
	        
	 
		}catch(Exception e) {
				e.printStackTrace();
				
			}
		
		
	}
	
	public void setScreenSize(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	public TelemetryScreenController getTelemetryController() {
		return telemetryController;
	}
}
