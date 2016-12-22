package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.components.ElevatorSpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class ElevatorSubsystem extends Subsystem implements IRambotsSubsystem {

	private static final ElevatorSpeedController ELEVATOR_SPEED_CONTROLLER = new ElevatorSpeedController();

	private static ElevatorSubsystem elevatorSubsystem;
	
	//---------------------------------------- Required definitions ----------------------------------//
	
	//TODO
	@Override
	public Subsystem getInstance() {
		if( elevatorSubsystem == null ){
			synchronized( ElevatorSubsystem.class ){
				if( elevatorSubsystem == null ){
					elevatorSubsystem = new ElevatorSubsystem();
				}
			}
		}
		return elevatorSubsystem;
	}
	
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