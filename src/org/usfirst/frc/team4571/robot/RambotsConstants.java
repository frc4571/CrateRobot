package org.usfirst.frc.team4571.robot;

/**
 * 
 * @author arjunrao87
 *
 */
public final class RambotsConstants {
	
	//--------------------------------------------------------------------------------------------//
	//---------------------------------- NETWORK CONSTANTS ---------------------------------------//
	//--------------------------------------------------------------------------------------------//
	
	// SRX Speed Controller Channel Mapping

	public static int REAR_RIGHT_TALON_CHANNEL  = 0;
	public static int FRONT_RIGHT_TALON_CHANNEL = 1;
	public static int FRONT_LEFT_TALON_CHANNEL  = 2;
	public static int REAR_LEFT_TALON_CHANNEL   = 3;
	
	// Joystick Channel Mapping
	
	public static int JOYSTICK_CHANNEL = 0;
	
	// Solenoid Channel Mapping
	
	public static final int ARM_SOLENOID_FORWARD_CHANNEL = 0;
	public static final int ARM_SOLENOID_REVERSE_CHANNEL = 1;
	public static final int SWEEPER_SOLENOID_FORWARD_CHANNEL = 2;
	public static final int SWEEPER_SOLENOID_REVERSE_CHANNEL = 3;
	
	// CAN IDs for Elevator Talon Speed Controllers 
	
	public static final int ELEVATOR_LEFT_TALON_CAN_ID = 1;
	public static final int ELEVATOR_RIGHT_TALON_CAN_ID = 2;
	
	// Limit switch channel mapping
	
	public static final int LEFT_ARM_DOWN_SWITCH_CHANNEL = 0;
	public static final int LEFT_ARM_UP_SWITCH_CHANNEL = 1;
	public static final int RIGHT_ARM_UP_SWITCH_CHANNEL = 2;
	public static final int RIGHT_ARM_DOWN_SWITCH_CHANNEL = 3;
	
	
	//--------------------------------------------------------------------------------------------//
	// ---------------------------------- OPERATION CONSTANTS ------------------------------------//
	//--------------------------------------------------------------------------------------------//
	
	public static final double ELEVATOR_CONSTANT_SPEED   = 0.5;
	public static final double JOYSTICK_TUNING_PARAMETER = 0.5;
	
	//--------------------------------------------------------------------------------------------//
	// -------------------------------------- OTHER CONSTANTS ------------------------------------//
	//--------------------------------------------------------------------------------------------//
	
	public static final String TEAM_ID_STRING = "4571";
	public static final int TEAM_ID = 4571;

}