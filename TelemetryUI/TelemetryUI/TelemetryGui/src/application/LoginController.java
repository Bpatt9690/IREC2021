package application;
import Interface.BackGroundController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class LoginController {
	
	private String userID = null;
	private String userPassword = null;

	@FXML
	private TextField userName;

   @FXML
   private PasswordField passwordField;
   
   @FXML
   private Button LoginButton;
   
   public void login() {
	   userID = userName.getText();
	   userPassword = passwordField.getText();	   
	   loginVerification(userID, userPassword);
   }
    
   private void loginVerification(String userID, String userPassword) {
	   
	   if(userID.equals("BlakeP") && userPassword.equals("Honda1"))
	   {
		   Alert confirmAlert = new Alert(AlertType.INFORMATION);
		   confirmAlert.setHeaderText("Succesful Login Redirecting Now");
		   confirmAlert.showAndWait();
		   startUp();
	   }
	   
	   else {
		   Alert errorAlert = new Alert(AlertType.ERROR);
	   	   errorAlert.setHeaderText("User Name or Password Incorrect");
	   	   errorAlert.showAndWait();
	   	   resetField();
	   }
		   
   }
   
   private void startUp() {
	   Screens s = new Screens();
	   TelemetryScreen ts = new TelemetryScreen(); 
	   ControlSystems controlSys = new ControlSystems();
	   LaunchPadSystems launchSys = new LaunchPadSystems();
	   BackGroundController backController = new BackGroundController();
	   
	   s.setScreens(ts,controlSys,launchSys);
	   ts.run();
	   controlSys.run();
	   launchSys.run();
	   s.run();
	   
	   ControlSystemsController systemsController = controlSys.getSysController();
	   systemsController.setController(backController);
	   backController.addInstallListener(systemsController);
	   
	   
	   TelemetryScreenController telemetryController = ts.getTelemetryController();
	   //System.out.println(telemetryController.hashCode());
	  telemetryController.setController(backController);
	   backController.addInstallListener(telemetryController);
	  // System.out.println(telemetryController);
	   
	  LaunchPadSystemsController launchController = launchSys.getLaunchController();
	   launchController.setController(backController);
	   backController.addInstallListener(launchController);
	   	   
   }
    
   private void resetField() {
	   userName.setText("");
	   passwordField.setText("");
   }


}
