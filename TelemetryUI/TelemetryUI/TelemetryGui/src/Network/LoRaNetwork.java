package Network;
import java.net.*;

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

import java.io.*;


public class LoRaNetwork extends Thread implements BackGroundInterface {

	private BackGroundController backgroundControl = null;
	private String address = null;
	private int port = 0;
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	private boolean killSocket = false;
	private boolean streamData = false;
	private BufferedReader reader = null;

	
	public LoRaNetwork(String address, int port, BackGroundController backgroundControl) {
		this.address = address;
		this.port = port;
		this.backgroundControl = backgroundControl;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println(address+ port);
		
		
		try {
			socket = new Socket(address, port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(killSocket == false) {
										
				if(streamData == true) {
					
					while(true) {
						
						try {
							Thread.sleep(500);
							String value = reader.readLine();
							seperateData(value);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} 
				
				}
				
			
			}
		}
	    catch(UnknownHostException u) 
        { 
            System.out.println(u); 
            //Add inform control systems UI here that socket did not connect
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
           //Add inform control systems UI here that socket did not connect
        } 
						
	}
	
	
	public void killSocket() {
		//this.killSocket = true;
		 try
	        { 
	            socket.close(); 
	        } 
	        catch(IOException i) 
	        { 
	            System.out.println(i); 
	        } 
		
	}
	
	public void restartSocket() {
		run();
	}
		
	public void seperateData(String data) {
		
		//This method will seperate incoming data to Pane associated with the data
		
		backgroundControl.startAlt(data+"\n");
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
		// TODO Auto-generated method stub
		//streamData = true;
		
	}

	@Override
	public void stopAlt(StopAltObjectEvent e) {
		killSocket();
		reader = null;
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
		this.streamData = true;
		
		
	}
	
}
