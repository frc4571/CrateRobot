package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

/**
 * Drive command in Teleop mode
 * 
 * Uses Tank drive 
 * 
 * @author arjunrao87
 *
 */
public class TeleopDriveCommand extends AbstractTeleopCommand{

	public TeleopDriveCommand(){
		requires( Robot.DRIVE_SUBSYSTEM );
	}
	
	@Override
	protected void initialize() {
		Robot.DRIVE_SUBSYSTEM.initializeSubsystem();
	}

	@Override
	protected void execute() {
		drive();
	}
	 
	public void drive(){
		Robot.DRIVE_SUBSYSTEM.drive( Robot.JOYSTICK_LEFT, Robot.JOYSTICK_RIGHT );
	}

	@Override
	protected void end() {}

	@Override
	protected boolean isFinished() {
		return Robot.DRIVE_SUBSYSTEM.getDistanceController().onTarget();
	}
}