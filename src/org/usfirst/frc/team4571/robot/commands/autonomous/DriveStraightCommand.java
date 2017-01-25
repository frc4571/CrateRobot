package org.usfirst.frc.team4571.robot.commands.autonomous;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author arjunrao
 *
 */
public class DriveStraightCommand extends Command {

	public DriveStraightCommand( double distance ){
		requires( Robot.DRIVE_SUBSYSTEM );
		Robot.DRIVE_SUBSYSTEM.setDriveParameters( distance, 0 );
	}
	
	@Override
	protected void initialize() {
		Robot.DRIVE_SUBSYSTEM.initializeSubsystem();
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return Robot.DRIVE_SUBSYSTEM.isStraightDriveFinished();
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
	}
}