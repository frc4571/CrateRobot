package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RambotsConstants;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class DrivePIDSubsystem extends Subsystem implements PIDOutput {

	/**
	 * Actuators
	 */
	private static final SpeedController FRONT_LEFT_SPEED_CONTROLLER  = new CANTalon(RambotsConstants.FRONT_LEFT_TALON_CHANNEL);
	private static final SpeedController FRONT_RIGHT_SPEED_CONTROLLER = new CANTalon(RambotsConstants.FRONT_RIGHT_TALON_CHANNEL);
	private static final SpeedController REAR_LEFT_SPEED_CONTROLLER   = new CANTalon(RambotsConstants.REAR_LEFT_TALON_CHANNEL);
	private static final SpeedController REAR_RIGHT_SPEED_CONTROLLER  = new CANTalon(RambotsConstants.REAR_RIGHT_TALON_CHANNEL);
	
	/**
	 * Sensors
	 */
	//Encoders
	private static final Encoder DRIVE_TRAIN_LEFT_ENCODER = new Encoder( RambotsConstants.LEFT_DRIVE_TRAIN_ENCODER_CHANNEL_A,
																		 RambotsConstants.LEFT_DRIVE_TRAIN_ENCODER_CHANNEL_B,
																		 true,
																		 EncodingType.k4X );
	private static final Encoder DRIVE_TRAIN_RIGHT_ENCODER = new Encoder( RambotsConstants.RIGHT_DRIVE_TRAIN_ENCODER_CHANNEL_A,
																		 RambotsConstants.RIGHT_DRIVE_TRAIN_ENCODER_CHANNEL_B,
																		 true,
																		 EncodingType.k4X );
	
	// NavX
	private static final AHRS NAV_X = new AHRS(SPI.Port.kMXP);	
    static final double navKp = 0.03;
    static final double navKi = 0.00;
    static final double navKd = 0.00;
    static final double navKf = 0.00;
	private final PIDController PID_CONTROLLER = new PIDController(navKp, navKi, navKd, NAV_X, this);
	
	/**
	 * Robot Drive
	 */
	private RobotDrive robotDrive;
	
	public DrivePIDSubsystem(){
		this.robotDrive = new RobotDrive(FRONT_LEFT_SPEED_CONTROLLER, REAR_LEFT_SPEED_CONTROLLER, FRONT_RIGHT_SPEED_CONTROLLER, REAR_RIGHT_SPEED_CONTROLLER);
		
		//Invert right side
		this.robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		this.robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		//Set safety
		this.robotDrive.setSafetyEnabled(true);
		this.robotDrive.setSensitivity(0.75);
		this.robotDrive.setMaxOutput(0.95);
	}
	
	public void initializeSubsystem(){	
		FRONT_LEFT_SPEED_CONTROLLER.set(0.0);
		FRONT_RIGHT_SPEED_CONTROLLER.set(0.0);
		REAR_LEFT_SPEED_CONTROLLER.set(0.0);
		REAR_RIGHT_SPEED_CONTROLLER.set(0.0);
		DRIVE_TRAIN_LEFT_ENCODER.reset();
		DRIVE_TRAIN_RIGHT_ENCODER.reset();
		NAV_X.reset();
	}
	
	//------------------------------------------ Required definitions ------------------------------------//
	
	//TODO
	@Override
	protected void initDefaultCommand() {
		// No default command
	}
	
	//-------------------------------------- Drive Subsystem specific methods ---------------------------------//
	
	// TODO : Not really sure how this will move the mecanum wheels, but we will find out.
	public void drive( double speed, double turn ){
		this.robotDrive.drive( speed, turn );
	}
	
	// TODO : Simple implementation of the mecanum drive. More to come later. 
	public void mecanumDrive( double xAxisSpeed, double yAxisSpeed, double rateOfRotation, double gyroAngle ){
		this.robotDrive.mecanumDrive_Cartesian( xAxisSpeed, yAxisSpeed, rateOfRotation, gyroAngle );
	}
	
	// Stop the drive system
	public void reset(){
		this.robotDrive.stopMotor();
		this.robotDrive.free();
	}

	@Override
	public void pidWrite(double output) {
		
	}
}