package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

/**
 * Command to move the arms in or out
 * 
 * Starting position is out
 * 
 * @author arjunrao87
 *
 */
public class TeleopArmCommand extends AbstractTeleopCommand{

	private boolean isArmsOut;
	
	public TeleopArmCommand(){
		requires( Robot.ARM_SUBSYSTEM );
	}
	
	@Override
	protected void initialize() {
		Robot.ARM_SUBSYSTEM.initializeSubsystem();
	}

	@Override
	protected void execute() {
		if( isArmsOut ){
			Robot.ARM_SUBSYSTEM.pushIn();
		} else{
			Robot.ARM_SUBSYSTEM.pushOut();
		}
		isArmsOut = !isArmsOut;
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}