package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.NetworkMapping;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class GrabSubsystem extends Subsystem {
	
	private static final DoubleSolenoid GRABBER_SOLENOID = new DoubleSolenoid(NetworkMapping.GRABBER_SOLENOID_FORWARD_CHANNEL, NetworkMapping.GRABBER_SOLENOID_REVERSE_CHANNEL);
	
	//---------------------------------------- Required definitions ----------------------------------//
	
	//TODO
	@Override
	protected void initDefaultCommand() {		
	}
	
	//-------------------------------------- Grab Subsystem specific methods ---------------------------------//

	public void pushOut(){
		GRABBER_SOLENOID.set( DoubleSolenoid.Value.kReverse );
	}
	
	public void pushIn(){
		GRABBER_SOLENOID.set( DoubleSolenoid.Value.kForward );
	}
	
	public Value getGrabberSolenoidValue(){
		return GRABBER_SOLENOID.get();
	}
	
	public void resetGrabberSolenoid(){
		GRABBER_SOLENOID.free();
	}
}