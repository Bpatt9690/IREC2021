package Interface;

import java.util.Vector;

public class BackGroundController {
private Vector<BackGroundInterface> listener = new Vector<BackGroundInterface>();
	
	public void addInstallListener(BackGroundInterface listenerObject) {
		listener.addElement(listenerObject);
	}
	
	public void removeInstallListener(BackGroundInterface listenerObject) {
		listener.removeElement(listenerObject);
	}
	
	@SuppressWarnings("unchecked")
	public void armRocket() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			ArmRocketObjectEvent newEvent = new ArmRocketObjectEvent(this);
			listenerCopy.armRocket(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void abortLaunch() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			AbortLaunchObjectEvent newEvent = new AbortLaunchObjectEvent(this);
			listenerCopy.abortLaunch(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void launchRocket() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			LaunchRocketObjectEvent newEvent = new LaunchRocketObjectEvent(this);
			listenerCopy.launchRocket(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void startAlt(String data) {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			StartAltObjectEvenet newEvent = new StartAltObjectEvenet(this);
			listenerCopy.startAlt(newEvent,data);
		}
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void stopAlt() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			StopAltObjectEvent newEvent = new StopAltObjectEvent(this);
			listenerCopy.stopAlt(newEvent);
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void startOrientation() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			StartOrientationObjectEvent newEvent = new StartOrientationObjectEvent(this);
			listenerCopy.startOrientation(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void stopOrientation() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			StopOrientationObjectEvent newEvent = new StopOrientationObjectEvent(this);
			listenerCopy.stopOrienatation(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void startPressure(String data) {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			StartPressureObjectEvent newEvent = new StartPressureObjectEvent(this);
			listenerCopy.startPressure(newEvent, data);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void stopPressure() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			StopPressureObjectEvent newEvent = new StopPressureObjectEvent(this);
			listenerCopy.stopPressure(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void startGraph() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			StartGraphObjectEvent newEvent = new StartGraphObjectEvent(this);
			listenerCopy.startGraph(newEvent);
		}
		
	}
	@SuppressWarnings("unchecked")
	public void stopGraph() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			StopGraphObjectEvent newEvent = new StopGraphObjectEvent(this);
			listenerCopy.stopGraph(newEvent);
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void fillValveOpen() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			FillValveOpenObjectEvent newEvent = new FillValveOpenObjectEvent(this);
			listenerCopy.fillValveOpen(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void fillValveClosed() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			FillValveClosedObjectEvent newEvent = new FillValveClosedObjectEvent(this);
			listenerCopy.fillValveClosed(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void purgeValveOpen() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			PurgeValveObjectEvent newEvent = new PurgeValveObjectEvent(this);
			listenerCopy.purgeValveOpen(newEvent);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void purgeValveClosed() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			PurgeValveClosedObjectEvent newEvent = new PurgeValveClosedObjectEvent(this);
			listenerCopy.purgeValveClosed(newEvent);
		}
		
	}

	@SuppressWarnings("unchecked")
	public void startAltStream() {
		Vector<BackGroundInterface> copy;
		
		synchronized(this) {
			copy = (Vector<BackGroundInterface>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			BackGroundInterface listenerCopy = (BackGroundInterface) copy.elementAt(i);
			AltStreamObject newEvent = new AltStreamObject(this);
			listenerCopy.startAltStream(newEvent);
		}
		
	}
	
	
	

}
