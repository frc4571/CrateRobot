package org.usfirst.frc.team4571.robot;

import org.usfirst.frc.team4571.robot.components.CustomJoystick;

import edu.wpi.first.wpilibj.Joystick;

/**
 * 
 * @author arjunrao87
 *
 */
public final class OperatorInterface {

	public static final Joystick JOYSTICK = new CustomJoystick(NetworkMapping.JOYSTICK_CHANNEL);
	
	
}