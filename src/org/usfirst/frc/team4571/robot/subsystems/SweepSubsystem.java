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
public class SweepSubsystem extends Subsystem {
	
	private static final DoubleSolenoid SWEEPER_SOLENOID = new DoubleSolenoid(RambotsConstants.SWEEPER_SOLENOID_FORWARD_CHANNEL, RambotsConstants.SWEEPER_SOLENOID_REVERSE_CHANNEL);
	
	//---------------------------------------- Required definitions ----------------------------------//
	
	//TODO
	@Override
	protected void initDefaultCommand() {		
	}
	
	//-------------------------------------- Sweep Subsystem specific methods ---------------------------------//

	public void initializeSubsystem() {
		sweepDown();
	}
	
	public void sweepUp(){
		SWEEPER_SOLENOID.set( DoubleSolenoid.Value.kReverse );
	}
	
	public void sweepDown(){
		SWEEPER_SOLENOID.set( DoubleSolenoid.Value.kForward );
	}

	public Value getSweeperSolenoidValue(){
		return SWEEPER_SOLENOID.get();
	}
	
	public void resetSweeperSolenoid(){
		SWEEPER_SOLENOID.free();
	}
}