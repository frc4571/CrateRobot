package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.NetworkMapping;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjrao
 *
 */
public class DriveSubsystem extends Subsystem implements RambotsSubsystem{

	public static final SpeedController FRONT_LEFT_SPEED_CONTROLLER  = new TalonSRX(NetworkMapping.FRONT_LEFT_TALON_CHANNEL);
	public static final SpeedController FRONT_RIGHT_SPEED_CONTROLLER = new TalonSRX(NetworkMapping.FRONT_RIGHT_TALON_CHANNEL);
	public static final SpeedController REAR_LEFT_SPEED_CONTROLLER   = new TalonSRX(NetworkMapping.REAR_LEFT_TALON_CHANNEL);
	public static final SpeedController REAR_RIGHT_SPEED_CONTROLLER  = new TalonSRX(NetworkMapping.REAR_RIGHT_TALON_CHANNEL);
	
	@Override
	public Subsystem getInstance() {
		return null;
	}
	
	@Override
	protected void initDefaultCommand() {
		// No default command
	}
}