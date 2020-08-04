package application;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LaunchPadSystems implements Runnable {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] devices = env.getScreenDevices();
	public double height = screenSize.getHeight();
	public double width = screenSize.getWidth();
	LaunchPadSystemsController launchController = null;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("LaunchPadXML.fxml"));
			Parent root = loader.load();
			Stage primaryStage = new Stage();
	        primaryStage.setTitle("Systems Control Panel");
	        primaryStage.setScene(new Scene(root, width, height));
	        primaryStage.show();
	        launchController = loader.getController();
	        }
			catch(Exception e) {
				e.printStackTrace();
				
			}
		
		
	}
	
	public void setScreenSize(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	public LaunchPadSystemsController getLaunchController() {
		return launchController;
	}
}