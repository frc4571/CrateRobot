package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

/**
 * Command to move the sweeper up or down
 * 
 * Starting position is down
 * 
 * @author arjunrao87
 *
 */
public class TeleopSweepCommand extends AbstractTeleopCommand{

	private boolean isPositionDown;
	
	public TeleopSweepCommand(){
		requires( Robot.SWEEP_SUBSYSTEM );
	}
	
	@Override
	protected void initialize() {
		Robot.SWEEP_SUBSYSTEM.initializeSubsystem();
	}

	@Override
	protected void execute() {
		if( isPositionDown ){
			Robot.SWEEP_SUBSYSTEM.sweepUp();
		} else{
			Robot.SWEEP_SUBSYSTEM.sweepDown();
		}
		isPositionDown = !isPositionDown;
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}