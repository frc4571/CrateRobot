package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

/**
 * This is a command to move the elevator system up. 
 * 
 * Note : It moves the elevator system at a fixed speed of 0.5.
 * At this point there are no control loops in place 
 * 
 * @author arjunrao87
 *
 */
public class SimpleTeleopElevatorUpCommand extends AbstractTeleopCommand{

	private boolean isLimitSwitches;

	// TODO : The boolean being passed is for debugging purposes. When we know 
	// how the limit switches work, we can get rid of this argument
	public SimpleTeleopElevatorUpCommand( boolean isLimitSwitches ){
		requires( Robot.ELEVATOR_SUBSYSTEM );
		this.isLimitSwitches = isLimitSwitches;
	}
	
	@Override
	protected void initialize() {
		Robot.ELEVATOR_SUBSYSTEM.initializeSubsytem();
		Robot.LEFT_ARM_UP_SWITCH.reset();
		Robot.RIGHT_ARM_UP_SWITCH.reset();
	}

	@Override
	protected void execute() {
		if( isLimitSwitches ){
			moveUpWithLimitSwitch();		
		} else{
			moveUp();
		}
	}

	public void moveUp(){
		Robot.ELEVATOR_SUBSYSTEM.moveUp(0.5);
	}
	
	public void moveUpWithLimitSwitch(){
		if( !Robot.LEFT_ARM_UP_SWITCH.isSet() && !Robot.RIGHT_ARM_UP_SWITCH.isSet() ){
			Robot.ELEVATOR_SUBSYSTEM.moveUp(0.5);
		}
	}
	
	@Override
	protected boolean isFinished() {
		if( isLimitSwitches ){
			return ( Robot.LEFT_ARM_UP_SWITCH.isSet() || !Robot.RIGHT_ARM_UP_SWITCH.isSet() ) ? true : false;
		}
		return false;
	}
}