package Interface;

import java.util.EventListener;

public interface BackGroundInterface extends EventListener {
	
	public void armRocket(ArmRocketObjectEvent e);
	public void startAltStream(AltStreamObject e);
	public void abortLaunch(AbortLaunchObjectEvent e);
	public void launchRocket(LaunchRocketObjectEvent e);
	public void startAlt(StartAltObjectEvenet e, String data);
	public void stopAlt(StopAltObjectEvent e);
	public void startOrientation(StartOrientationObjectEvent e);
	public void stopOrienatation(StopOrientationObjectEvent e);
	public void startPressure(StartPressureObjectEvent e, String data);
	public void stopPressure(StopPressureObjectEvent e);
	public void startGraph(StartGraphObjectEvent e);
	public void stopGraph(StopGraphObjectEvent e);
	public void fillValveOpen(FillValveOpenObjectEvent e);
	public void fillValveClosed(FillValveClosedObjectEvent e);
	public void purgeValveOpen(PurgeValveObjectEvent e);
	public void purgeValveClosed(PurgeValveClosedObjectEvent e);

}
