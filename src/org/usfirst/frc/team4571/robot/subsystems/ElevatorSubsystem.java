package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.subsystems.components.ElevatorSpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
	
	public static final ElevatorSpeedController ELEVATOR_SPEED_CONTROLLER = new ElevatorSpeedController();
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void initialize() {
    	ELEVATOR_SPEED_CONTROLLER.initialize();
    }
    
    public void goUp(double speed) {
    	ELEVATOR_SPEED_CONTROLLER.goUp(speed);
    }
    
    public void goDown(double speed) {
    	ELEVATOR_SPEED_CONTROLLER.goDown(speed);
    }
    
    public void stop() {
    	ELEVATOR_SPEED_CONTROLLER.stop();
    }
}

