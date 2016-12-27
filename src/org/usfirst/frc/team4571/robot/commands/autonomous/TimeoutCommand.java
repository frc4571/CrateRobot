package org.usfirst.frc.team4571.robot.commands.autonomous;


/**
 * 
 * @author arjunrao87
 *
 */
public class TimeoutCommand extends AbstractAutonomousCommand{

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
}