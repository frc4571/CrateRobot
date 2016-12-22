package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.NetworkMapping;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class ArmSubsystem extends Subsystem implements RambotsSubsystem {
	
	public static final SolenoidBase GRABBER_SOLENOID = new DoubleSolenoid(NetworkMapping.GRABBER_SOLENOID_FORWARD_CHANNEL, NetworkMapping.GRABBER_SOLENOID_REVERSE_CHANNEL);
	public static final SolenoidBase SWEEPER_SOLENOID = new DoubleSolenoid(NetworkMapping.SWEEPER_SOLENOID_FORWARD_CHANNEL, NetworkMapping.SWEEPER_SOLENOID_REVERSE_CHANNEL);
	
	@Override
	public Subsystem getInstance() {
		return null;
	}
	
	@Override
	protected void initDefaultCommand() {		
	}
}