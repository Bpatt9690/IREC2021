package application;

import java.awt.GraphicsEnvironment;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.HeadlessException;
import java.awt.Toolkit;


//1-2-3 from left to right
	public class Screens implements Runnable {

		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 TelemetryScreen telemetry = null;
		 ControlSystems controlSys = null;
		 LaunchPadSystems launchSys = null;
		 private int leftScreenWidth;
		 private int leftScreenHeight;
		 private int centerScreenWidth;
		 private int centerScreenHeight;
		 private int rightScreenWidth;
		 private int rightScreenHeight;
		 
		 
			@Override
			public void run() {
				try {
	
	            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	            GraphicsDevice[] devices = env.getScreenDevices();

	            for(int i = 0; i < 2; i++) {
	            DisplayMode dm = devices[i].getDisplayMode();
	            
	            if(i == 0) {
	            	leftScreenWidth = dm.getWidth();
	            	leftScreenHeight = dm.getHeight();
	            	telemetry.setScreenSize(leftScreenHeight,leftScreenWidth);
	            }
	            
	            else if(i == 1) {
	            	centerScreenWidth = dm.getWidth();
	            	centerScreenHeight = dm.getHeight();
	            	controlSys.setScreenSize(centerScreenHeight, centerScreenWidth);
	            }
	            
	            else if(i == 2) {
	            	System.out.println("yeet");
	            	rightScreenWidth = dm.getWidth();
	            	rightScreenHeight = dm.getHeight();
	            	launchSys.setScreenSize(rightScreenHeight, rightScreenWidth);
	            }

	            }
	            
	             
	        } catch (HeadlessException e) {

	            e.printStackTrace();
	        }
				
		}
			
			public void setScreens(TelemetryScreen telemetry, ControlSystems controlSys, LaunchPadSystems launchSys) {//, ControlSystems controlSys){
				this.telemetry = telemetry;
				this.controlSys = controlSys;
				this.launchSys = launchSys;
			}
	   
	}


