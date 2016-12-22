package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

/**
 * Drive command in Teleop mode
 * 
 * Uses Mecanum drive as sole driving method
 * 
 * @author arjunrao87
 *
 */
public class TeleopDriveCommand extends AbstractTeleopCommand{

	public TeleopDriveCommand(){
		super( "TeleOpDriveCommand" );
		requires( Robot.DRIVE_SUBSYSTEM );
	}
	
	@Override
	protected void initialize() {
		Robot.DRIVE_SUBSYSTEM.initializeSubsystem();
	}

	@Override
	protected void execute() {
		driveMecanum();
	}
	
	//TODO : Should gyro angle be used or is this 
	public void driveMecanum(){
		Robot.DRIVE_SUBSYSTEM.mecanumDrive(Robot.JOYSTICK.getXAxisSpeed(), Robot.JOYSTICK.getYAxisSpeed(), Robot.JOYSTICK.getRotationSpeed(), 0.0 );
	}

	@Override
	protected void end() {
		Robot.DRIVE_SUBSYSTEM.mecanumDrive( 0.0, 0.0, 0.0, 0.0 );
	}
}