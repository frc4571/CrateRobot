package org.usfirst.frc.team4571.robot.subsystems.components;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSpeedController extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon leftSpeed;
	private CANTalon rightSpeed;
	
	public ElevatorSpeedController() {
		this.leftSpeed = new CANTalon(1); //TODO: change it to constant
		this.rightSpeed = new CANTalon(2); //TODO: change it to constant
	}
	
	public void initialize() {
		this.leftSpeed.reset();
		this.rightSpeed.reset();
	}
	
	public void goUp(double speed) {
		this.leftSpeed.set(speed);
		this.rightSpeed.set(speed);
	}
	
	public void goDown(double speed) {
		this.rightSpeed.set(speed);
		this.leftSpeed.set(speed);
	}
	
	public void stop() {
		this.leftSpeed.set(0.0);
		this.rightSpeed.set(0.0);
		this.leftSpeed.disableControl();
		this.rightSpeed.disableControl();
		this.leftSpeed.reset();
		this.rightSpeed.reset();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

