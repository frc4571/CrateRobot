package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.ElevatorSpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class ElevatorSubsystem extends Subsystem implements RambotsSubsystem {

	public static final ElevatorSpeedController ELEVATOR_SPEED_CONTROLLER = new ElevatorSpeedController();

	@Override
	public Subsystem getInstance() {
		return null;
	}
	
	@Override
	protected void initDefaultCommand() {		
	}
}