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
	
	public static int LEFT_JOYSTICK_CHANNEL  = 0;
	public static int RIGHT_JOYSTICK_CHANNEL = 1;
	
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
	
	// Sensors
	
	public static final int LEFT_DRIVE_TRAIN_ENCODER_CHANNEL_A  = 1;
	public static final int LEFT_DRIVE_TRAIN_ENCODER_CHANNEL_B  = 2;
	public static final int RIGHT_DRIVE_TRAIN_ENCODER_CHANNEL_A = 3;
	public static final int RIGHT_DRIVE_TRAIN_ENCODER_CHANNEL_B = 4;
	
	
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
	// Why this is set to 360 and formula for DPP
	// https://www.chiefdelphi.com/forums/showpost.php?p=1525618&postcount=4
	public static final double ENCODER_PULSES_PER_REVOLUTION = 360;
	public static final double ENCODER_GEAR_RATIO = 0;
	public static final double GEAR_RATIO = 10.1;
	public static final double WHEEL_RADIUS_IN_INCHES = 6;
	public static final double ENCODER_FUDGE_FACTOR = 1;
	public static final double ENCODER_DISTANCE_PER_PULSE = ( ( 2* Math.PI * RambotsConstants.WHEEL_RADIUS_IN_INCHES ) / RambotsConstants.ENCODER_PULSES_PER_REVOLUTION / RambotsConstants.ENCODER_GEAR_RATIO / RambotsConstants.GEAR_RATIO * RambotsConstants.ENCODER_FUDGE_FACTOR );

}