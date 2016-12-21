package org.usfirst.frc.team4571.robot;

/**
 * 
 * @author arjrao
 *
 */
public final class NetworkMapping {
	
	// SRX Speed Controller Channel Mapping

	public static int REAR_RIGHT_TALON_CHANNEL  = 0;
	public static int FRONT_RIGHT_TALON_CHANNEL = 1;
	public static int FRONT_LEFT_TALON_CHANNEL  = 2;
	public static int REAR_LEFT_TALON_CHANNEL   = 3;
	
	// Joystick Channel Mapping
	
	public static int JOYSTICK_CHANNEL = 0;
	
	// Solenoid Channel Mapping
	
	public static final int GRABBER_SOLENOID_FORWARD_CHANNEL = 0;
	public static final int GRABBER_SOLENOID_REVERSE_CHANNEL = 1;
	public static final int SWEEPER_SOLENOID_FORWARD_CHANNEL = 2;
	public static final int SWEEPER_SOLENOID_REVERSE_CHANNEL = 3;
	
	// CAN IDs for Elevator Talon Speed Controllers 
	
	public static final int ELEVATOR_LEFT_TALON_CAN_ID = 1;
	public static final int ELEVATOR_RIGHT_TALON_CAN_ID = 2;
	
}