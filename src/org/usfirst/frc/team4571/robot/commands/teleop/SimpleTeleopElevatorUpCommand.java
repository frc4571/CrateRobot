package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.computations.ComputationConstants;

/**
 * This is a command to move the elevator system up. 
 * 
 * Note : It moves the elevator system at a fixed speed of ComputationConstants.ELEVATOR_CONSTANT_SPEED
 * At this point there are no control loops in place 
 * 
 * @author arjunrao87
 *
 */
public class SimpleTeleopElevatorUpCommand extends AbstractTeleopCommand{

	public SimpleTeleopElevatorUpCommand(){
		requires( Robot.ELEVATOR_SUBSYSTEM );
	}
	
	@Override
	protected void initialize() {
		Robot.ELEVATOR_SUBSYSTEM.initializeSubsytem();
		Robot.LEFT_ARM_UP_SWITCH.reset();
		Robot.RIGHT_ARM_UP_SWITCH.reset();
	}

	@Override
	protected void execute() {
		moveUpWithLimitSwitch();		
	}
	
	public void moveUpWithLimitSwitch(){
		if( !Robot.LEFT_ARM_UP_SWITCH.isSet() && !Robot.RIGHT_ARM_UP_SWITCH.isSet() ){
			Robot.ELEVATOR_SUBSYSTEM.moveUp( ComputationConstants.ELEVATOR_CONSTANT_SPEED );
		}
	}
	
	@Override
	protected boolean isFinished() {
		return ( Robot.LEFT_ARM_UP_SWITCH.isSet() || !Robot.RIGHT_ARM_UP_SWITCH.isSet() ) ? true : false;
	}
}