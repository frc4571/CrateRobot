package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.NetworkMapping;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class ArmSubsystem extends Subsystem implements IRambotsSubsystem {
	
	private static final DoubleSolenoid GRABBER_SOLENOID = new DoubleSolenoid(NetworkMapping.GRABBER_SOLENOID_FORWARD_CHANNEL, NetworkMapping.GRABBER_SOLENOID_REVERSE_CHANNEL);
	private static final DoubleSolenoid SWEEPER_SOLENOID = new DoubleSolenoid(NetworkMapping.SWEEPER_SOLENOID_FORWARD_CHANNEL, NetworkMapping.SWEEPER_SOLENOID_REVERSE_CHANNEL);
	
	public ArmSubsystem() {
	
	}
	
	//---------------------------------------- Required definitions ----------------------------------//

	//TODO
	@Override
	public Subsystem getInstance() {
		return null;
	}
	
	//TODO
	@Override
	protected void initDefaultCommand() {		
	}
	
	//-------------------------------------- Arm Subsystem specific methods ---------------------------------//

	public void pushOut(){
		GRABBER_SOLENOID.set( DoubleSolenoid.Value.kReverse );
	}
	
	public void pushIn(){
		GRABBER_SOLENOID.set( DoubleSolenoid.Value.kForward );
	}
	
	public void sweepUp(){
		SWEEPER_SOLENOID.set( DoubleSolenoid.Value.kReverse );
	}
	
	public void sweepDown(){
		SWEEPER_SOLENOID.set( DoubleSolenoid.Value.kForward );
	}
}