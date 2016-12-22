package org.usfirst.frc.team4571.robot.components;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * Defining buttons, sensitivities, control parameters for the joystick used to control this robot.
 * 
 * @author arjunrao87
 *
 */
public class RambotsJoystick extends Joystick{

	private final Button buttonA;
	private final Button buttonB;
	private final Button buttonX;
	private final Button buttonY;
	
	public RambotsJoystick(int port) {
		super(port);
		this.buttonA = new JoystickButton( this, 1 );
		this.buttonB = new JoystickButton( this, 2 );
		this.buttonX = new JoystickButton( this, 3 );
		this.buttonY = new JoystickButton( this, 4 );	
	}
	
	//TODO
	public void assignButtonFunctions(){
		
	}	
	
	public Button getButtonA(){
		return this.buttonA;
	}
	
	public Button getButtonB(){
		return this.buttonB;
	}
	
	public Button getButtonX(){
		return this.buttonX;
	}
	
	public Button getButtonY(){
		return this.buttonY;
	}
}