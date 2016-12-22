package org.usfirst.frc.team4571.robot.components;

import org.usfirst.frc.team4571.robot.NetworkMapping;
import org.usfirst.frc.team4571.robot.exception.InvalidRambotOperationException;

import edu.wpi.first.wpilibj.CANTalon;

/**
 * Wrapper class for the operation of the 2 talons that operate the elevator system
 * 
 * @author arjunrao87
 *
 */
public class ElevatorSpeedController{

	private CANTalon leftSpeedController;
	private CANTalon rightSpeedController;
	
	public ElevatorSpeedController(){
		this.leftSpeedController  = new CANTalon( NetworkMapping.ELEVATOR_LEFT_TALON_CAN_ID );
		this.rightSpeedController = new CANTalon( NetworkMapping.ELEVATOR_RIGHT_TALON_CAN_ID );
	}
	
	public void moveUp( double upwardSpeed ){
		if( upwardSpeed < 0 ){
			throw new InvalidRambotOperationException( "Negative speed provided. Please provide positive speed to move up." );
		}
		this.leftSpeedController.set(upwardSpeed);
		this.rightSpeedController.set(upwardSpeed);
	}
	
	public void moveDown( double downwardSpeed ){
		if( downwardSpeed > 0 ){
			throw new InvalidRambotOperationException( "Positive speed provided. Please provide negative speed to move down." );
		}
		this.leftSpeedController.set(downwardSpeed);
		this.rightSpeedController.set(downwardSpeed);
	}
	
	public void stop(){
		this.leftSpeedController.set(0.0);
		this.rightSpeedController.set(0.0);
		this.leftSpeedController.reset();
		this.rightSpeedController.reset();
	}
}