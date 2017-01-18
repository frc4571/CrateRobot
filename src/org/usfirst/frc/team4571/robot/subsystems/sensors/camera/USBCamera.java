package org.usfirst.frc.team4571.robot.subsystems.sensors.camera;

import edu.wpi.first.wpilibj.CameraServer;

/**
 * 
 * Wrapper class for the WPI USBCamera. Maybe its not required. 
 * Placeholder for now incase additional functions are needed.
 * 
 * @author arjunrao87
 *
 */
public class USBCamera {
	
	private edu.wpi.first.wpilibj.vision.USBCamera camera;
	
	public USBCamera( String cameraName ){
		this.camera = new edu.wpi.first.wpilibj.vision.USBCamera( cameraName );
		this.camera.setWhiteBalanceAuto();
	}
	
	public void start(){
		CameraServer.getInstance().startAutomaticCapture(camera);
	}
	
	public void update(){
		this.camera.updateSettings();
	}
	
	public edu.wpi.first.wpilibj.vision.USBCamera getCamera(){
		return this.camera;
	}
}