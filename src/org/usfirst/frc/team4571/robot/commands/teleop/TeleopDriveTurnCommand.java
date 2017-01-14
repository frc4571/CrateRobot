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
public class TeleopDriveTurnCommand extends AbstractTeleopCommand{

	public enum TurnAngle{
		TURN_0( 0.0f ),
		TURN_90( 90.0f ),
		TURN_180( 179.9f ),
		TURN_MINUS_90( -90.0f );
		
		private float angle;

		private TurnAngle( float angle ){
			this.angle = angle;
		}
		
		public float getAngle(){
			return this.angle;
		}
	}

	private TurnAngle angle;
	
	public TeleopDriveTurnCommand( TurnAngle angle ){
		requires( Robot.DRIVE_PID_SUBSYSTEM );
		this.angle = angle;
	}
	
	@Override
	protected void initialize() {
		Robot.DRIVE_PID_SUBSYSTEM.initializeSubsystem();
	}

	@Override
	protected void execute() {
		turn();
	}
	 
	public void turn(){
		Robot.DRIVE_PID_SUBSYSTEM.getTurnController().enable();
		Robot.DRIVE_PID_SUBSYSTEM.getTurnController().setSetpoint(this.angle.getAngle());
		// TODO : Will this work when the robot is moving?
		Robot.DRIVE_PID_SUBSYSTEM.drive();
	}

	@Override
	protected void end() {
		Robot.DRIVE_SUBSYSTEM.mecanumDrive( 0.0, 0.0, 0.0, 0.0 );
	}

	@Override
	protected boolean isFinished() {
		return Robot.DRIVE_PID_SUBSYSTEM.getTurnController().onTarget();
	}
}