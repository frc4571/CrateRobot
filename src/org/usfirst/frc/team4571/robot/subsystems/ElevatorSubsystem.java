package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RambotsConstants;
import org.usfirst.frc.team4571.robot.subsystems.components.ElevatorSpeedController;
import org.usfirst.frc.team4571.robot.subsystems.sensors.LimitSwitch;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class ElevatorSubsystem extends Subsystem {

	private static final ElevatorSpeedController ELEVATOR_SPEED_CONTROLLER = new ElevatorSpeedController();
	
	// Limit switches
	private final LimitSwitch leftArmUpSwitch    = new LimitSwitch( RambotsConstants.LEFT_ARM_UP_SWITCH_CHANNEL );
	private final LimitSwitch leftArmDownSwitch  = new LimitSwitch( RambotsConstants.LEFT_ARM_DOWN_SWITCH_CHANNEL );
	private final LimitSwitch rightArmUpSwitch   = new LimitSwitch( RambotsConstants.RIGHT_ARM_UP_SWITCH_CHANNEL );
	private final LimitSwitch rightArmDownSwitch = new LimitSwitch( RambotsConstants.RIGHT_ARM_DOWN_SWITCH_CHANNEL );
	
	//---------------------------------------- Required definitions ----------------------------------//
 
	//TODO
	@Override
	protected void initDefaultCommand() {	
		// No default command
	}
	
	//---------------------------------------- Elevator System definitions ----------------------------------//
	
	public void initializeSubsytem(){
		ELEVATOR_SPEED_CONTROLLER.initialize();
	}
	
	public void moveUp( double speed ){
		ELEVATOR_SPEED_CONTROLLER.moveUp( speed );
	}
	
	public void moveDown( double speed ){
		ELEVATOR_SPEED_CONTROLLER.moveDown(speed);
	}
	
	public void stop(){
		ELEVATOR_SPEED_CONTROLLER.stop();
	}

	public LimitSwitch getLeftArmUpSwitch() {
		return leftArmUpSwitch;
	}

	public LimitSwitch getLeftArmDownSwitch() {
		return leftArmDownSwitch;
	}

	public LimitSwitch getRightArmUpSwitch() {
		return rightArmUpSwitch;
	}

	public LimitSwitch getRightArmDownSwitch() {
		return rightArmDownSwitch;
	}
}