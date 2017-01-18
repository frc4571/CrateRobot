package org.usfirst.frc.team4571.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author arjunrao87
 *
 */
public class TimeoutCommand extends Command{

    private double timeout;

	public TimeoutCommand( double timeout ){
    	this.timeout = timeout;
	}
	
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return super.timeSinceInitialized() >= timeout;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {		
	}
}