package org.usfirst.frc.team4571.robot.commands.autonomous;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author arjunrao
 *
 */
public class DriveStraightCommand extends Command {

	private double distance;

	public DriveStraightCommand( double distance ){
		this.distance = distance;
		requires( Robot.DRIVE_PID_SUBSYSTEM );
	}
	
	@Override
	protected void initialize() {
		Robot.DRIVE_PID_SUBSYSTEM.initializeSubsystem();
	}

	@Override
	protected void execute() {
		Robot.DRIVE_PID_SUBSYSTEM.drive(distance);
	}

	@Override
	protected boolean isFinished() {
		return Robot.DRIVE_PID_SUBSYSTEM.isStraightDriveFinished();
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
	}
}