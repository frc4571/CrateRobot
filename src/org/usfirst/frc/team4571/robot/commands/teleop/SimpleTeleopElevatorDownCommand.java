package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

/**
 * This is a command to move the elevator system down. 
 * 
 * Note : It moves the elevator system at a fixed speed of 0.5.
 * At this point there are no control loops in place 
 * 
 * @author arjunrao87
 *
 */
public class SimpleTeleopElevatorDownCommand extends AbstractTeleopCommand{

	public SimpleTeleopElevatorDownCommand(){
		requires( Robot.ELEVATOR_SUBSYSTEM );
	}
	
	@Override
	protected void initialize() {
		Robot.ELEVATOR_SUBSYSTEM.initializeSubsytem();
		Robot.LEFT_ARM_DOWN_SWITCH.reset();
		Robot.RIGHT_ARM_DOWN_SWITCH.reset();
	}

	@Override
	protected void execute() {
		moveDownWithLimitSwitch();
	}

	public void moveDownWithLimitSwitch(){
		if( !Robot.LEFT_ARM_DOWN_SWITCH.isSet() && !Robot.RIGHT_ARM_DOWN_SWITCH.isSet() ){
			Robot.ELEVATOR_SUBSYSTEM.moveDown(0.5);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return ( Robot.LEFT_ARM_DOWN_SWITCH.isSet() || !Robot.RIGHT_ARM_DOWN_SWITCH.isSet() ) ? true : false;
	}
}