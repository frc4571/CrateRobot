package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RambotsConstants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class ArmSubsystem extends Subsystem {
	
	private static final DoubleSolenoid ARM_SOLENOID = new DoubleSolenoid(RambotsConstants.ARM_SOLENOID_FORWARD_CHANNEL, RambotsConstants.ARM_SOLENOID_REVERSE_CHANNEL);

	//---------------------------------------- Required definitions ----------------------------------//
	
	//TODO
	@Override
	protected void initDefaultCommand() {		
	}
	
	//-------------------------------------- Grab Subsystem specific methods ---------------------------------//

	public void initializeSubsystem(){
		pushOut();
	}
	
	public void pushOut(){
		ARM_SOLENOID.set( DoubleSolenoid.Value.kReverse );
	}
	
	public void pushIn(){
		ARM_SOLENOID.set( DoubleSolenoid.Value.kForward );
	}
	
	public Value getArmSolenoidValue(){
		return ARM_SOLENOID.get();
	}
	
	public void resetArmSolenoid(){
		ARM_SOLENOID.free();
	}
}