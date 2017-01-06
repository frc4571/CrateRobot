package org.usfirst.frc.team4571.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;


public class ElevatorJoystickConfiguration extends Joystick{
	 private final Button button3;
	 private final Button button2;
	
	public ElevatorJoystickConfiguration(int port) {
		super(port);
		this.button3 = new JoystickButton(this, 3);
		this.button2 = new JoystickButton(this, 2);
	    

		// TODO Auto-generated constructor stub
	}
    
	public ElevatorJoystickConfiguration button3WhenPressed(Command ElevatorCommandUp){
		this.button3.whenPressed(ElevatorCommandUp);
		return this;
	}

    public ElevatorJoystickConfiguration button3WhenReleased(Command ElevatorStopCommand){
    	this.button3.whenReleased(ElevatorStopCommand);
    	return this;
    }
    
    public ElevatorJoystickConfiguration button2WhenPressed(Command ElevatorCommandDown){
    	this.button2.whenPressed(ElevatorCommandDown);
    	return this;
    }

    public ElevatorJoystickConfiguration button2WhenReleased(Command ElevatorStopCommand){
    	this.button2.whenReleased(ElevatorStopCommand);
    	return this;
    }
     
    public Button getButton3(){
    	return this.button3;
    }

    public Button getButton2(){
    	return this.button2;
    }
}
