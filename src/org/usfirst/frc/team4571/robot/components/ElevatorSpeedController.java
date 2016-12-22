package org.usfirst.frc.team4571.robot.components;

import org.usfirst.frc.team4571.robot.NetworkMapping;
import org.usfirst.frc.team4571.robot.exception.InvalidRambotOperationException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;

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
		this( false );
	}
	
	public ElevatorSpeedController( boolean isInverted ){
		this.leftSpeedController  = new CANTalon( NetworkMapping.ELEVATOR_LEFT_TALON_CAN_ID );
		this.rightSpeedController = new CANTalon( NetworkMapping.ELEVATOR_RIGHT_TALON_CAN_ID );
		this.leftSpeedController.setInverted(isInverted);
		this.rightSpeedController.setInverted(isInverted);
	}
	
	public void moveUp( double upwardSpeed ){
		if( upwardSpeed < 0 ){
			throw new InvalidRambotOperationException( "Negative speed provided. Please provide positive speed to move up." );
		}
		this.leftSpeedController.set(upwardSpeed);
		this.rightSpeedController.set(upwardSpeed);
		
		//TODO : Is this even required?
		// The CANTalon only receives updates every 10ms, so updating more quickly would not be useful
		Timer.delay(0.01);
	}
	
	public void moveDown( double downwardSpeed ){
		if( downwardSpeed > 0 ){
			throw new InvalidRambotOperationException( "Positive speed provided. Please provide negative speed to move down." );
		}
		this.leftSpeedController.set(downwardSpeed);
		this.rightSpeedController.set(downwardSpeed);
		
		//TODO : Is this even required?
		// The CANTalon only receives updates every 10ms, so updating more quickly would not be useful
		Timer.delay(0.01);
	}
	
	public void stop(){
		this.leftSpeedController.set(0.0);
		this.rightSpeedController.set(0.0);
		this.leftSpeedController.disableControl();
		this.rightSpeedController.disableControl();
		this.leftSpeedController.reset();
		this.rightSpeedController.reset();
	}
	
	public boolean isEnabled(){
		return leftSpeedController.isEnabled() && rightSpeedController.isEnabled();
	}
	
	public double getLeftSpeedControllerError(){
		return this.leftSpeedController.getError();
	}
	
	public double getRightSpeedControllerError(){
		return this.rightSpeedController.getError();
	}
}