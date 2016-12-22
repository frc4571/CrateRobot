package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.components.ElevatorSpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class ElevatorSubsystem extends Subsystem {

	private static final ElevatorSpeedController ELEVATOR_SPEED_CONTROLLER = new ElevatorSpeedController();
	
	//---------------------------------------- Required definitions ----------------------------------//
 
	//TODO
	@Override
	protected void initDefaultCommand() {	
		// No default command
	}
	
	//---------------------------------------- Elevator System definitions ----------------------------------//
	
	public void moveUp( double speed ){
		ELEVATOR_SPEED_CONTROLLER.moveUp( speed );
	}
	
	public void moveDown( double speed ){
		ELEVATOR_SPEED_CONTROLLER.moveDown(speed);
	}
	
	public void stop(){
		ELEVATOR_SPEED_CONTROLLER.stop();
	}
}