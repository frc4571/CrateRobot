package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.RambotsConstants;
import org.usfirst.frc.team4571.robot.Robot;

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
		Robot.ELEVATOR_SUBSYSTEM.getLeftArmUpSwitch().reset();
		Robot.ELEVATOR_SUBSYSTEM.getRightArmUpSwitch().reset();
	}

	@Override
	protected void execute() {
		moveUpWithLimitSwitch();		
	}
	
	public void moveUpWithLimitSwitch(){
		if( !Robot.ELEVATOR_SUBSYSTEM.getLeftArmUpSwitch().isSet() && !Robot.ELEVATOR_SUBSYSTEM.getRightArmUpSwitch().isSet() ){
			Robot.ELEVATOR_SUBSYSTEM.moveUp( RambotsConstants.ELEVATOR_CONSTANT_SPEED );
		}
	}
	
	@Override
	protected boolean isFinished() {
		return ( Robot.ELEVATOR_SUBSYSTEM.getLeftArmUpSwitch().isSet() || !Robot.ELEVATOR_SUBSYSTEM.getRightArmUpSwitch().isSet() ) ? true : false;
	}
}