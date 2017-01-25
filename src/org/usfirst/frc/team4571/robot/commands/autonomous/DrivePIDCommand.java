package org.usfirst.frc.team4571.robot.commands.autonomous;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author arjunrao
 *
 */
public class DrivePIDCommand extends Command {

	public DrivePIDCommand( double distance, double angle ){
		requires( Robot.DRIVE_PID_SUBSYSTEM );
		Robot.DRIVE_PID_SUBSYSTEM.setDriveParameters( distance, angle );
	}
	
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return Robot.DRIVE_PID_SUBSYSTEM.isFinished();
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
	}
}