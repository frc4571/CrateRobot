package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.RambotsConstants;
import org.usfirst.frc.team4571.robot.Robot;

/**
 * This is a command to move the elevator system down. 
 * 
 * Note : It moves the elevator system at a fixed speed of ComputationConstants.ELEVATOR_CONSTANT_SPEED
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
		Robot.ELEVATOR_SUBSYSTEM.getLeftArmDownSwitch().reset();
		Robot.ELEVATOR_SUBSYSTEM.getRightArmDownSwitch().reset();
	}

	@Override
	protected void execute() {
		moveDownWithLimitSwitch();
	}

	public void moveDownWithLimitSwitch(){
		if( !Robot.ELEVATOR_SUBSYSTEM.getLeftArmDownSwitch().isSet() && !Robot.ELEVATOR_SUBSYSTEM.getRightArmDownSwitch().isSet() ){
			Robot.ELEVATOR_SUBSYSTEM.moveDown( RambotsConstants.ELEVATOR_CONSTANT_SPEED );
		}
	}
	
	@Override
	protected boolean isFinished() {
		return ( Robot.ELEVATOR_SUBSYSTEM.getLeftArmDownSwitch().isSet() || !Robot.ELEVATOR_SUBSYSTEM.getRightArmDownSwitch().isSet() ) ? true : false;
	}
}