package org.usfirst.frc.team4571.robot.commands.autonomous;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author arjunrao
 *
 */
public class DriveCommand extends Command {

	public DriveCommand( double distance, double angle ){
		requires( Robot.DRIVE_SUBSYSTEM );
		Robot.DRIVE_SUBSYSTEM.setDriveParameters( distance, angle );
	}
	
	@Override
	protected void initialize() {
		Robot.DRIVE_SUBSYSTEM.initializeSubsystem();
	}

	// Does not need to be implemented since the PID controller is in charge of motion
	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return Robot.DRIVE_SUBSYSTEM.isFinished();
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
}