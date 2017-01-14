package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RambotsConstants;
import org.usfirst.frc.team4571.robot.subsystems.pid.RetrievePIDOutput;
import org.usfirst.frc.team4571.robot.subsystems.sensors.AverageDistanceEncoder;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * 
 * @author arjunrao87
 *
 */
public class DrivePIDSubsystem extends Subsystem{

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
	private double encoderKp;
	private double encoderKi;
	private double encoderKd;
	private double encoderPeriod = 10;
	
	// NavX
	private static final AHRS NAV_X = new AHRS(SPI.Port.kMXP);	
	private double navKp;
	private double navKi;
	private double navKd;
	private double navXPeriod = 10;
	private final double kToleranceDegrees = 2.0f;
	
	// PIDSource, PIDOutput
	private final AverageDistanceEncoder averageDistanceEncoder;
	private final RetrievePIDOutput distancePIDOutput;
	private final RetrievePIDOutput turnPIDOutput;
	
	// PID Controllers
	private final PIDController distanceController;
	private final PIDController turnController;
	
	/**
	 * Robot Drive
	 */
	private RobotDrive robotDrive;
	
	public DrivePIDSubsystem(){
		// Robot Drive
		this.robotDrive = new RobotDrive(FRONT_LEFT_SPEED_CONTROLLER, REAR_LEFT_SPEED_CONTROLLER, FRONT_RIGHT_SPEED_CONTROLLER, REAR_RIGHT_SPEED_CONTROLLER);
		
		//Invert right side
		this.robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		this.robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		//Set safety
		this.robotDrive.setSafetyEnabled(true);
		this.robotDrive.setSensitivity(0.75);
		this.robotDrive.setMaxOutput(0.95);
		
		// Set up PID Controllers
		this.averageDistanceEncoder = new AverageDistanceEncoder(DRIVE_TRAIN_LEFT_ENCODER, DRIVE_TRAIN_RIGHT_ENCODER);
		this.distancePIDOutput = new RetrievePIDOutput();
		this.distanceController = new PIDController(encoderKp, encoderKi, encoderKd, averageDistanceEncoder, distancePIDOutput, encoderPeriod);
		this.distanceController.setPercentTolerance(5.0);
		this.distanceController.setContinuous(false);
		
		this.turnPIDOutput = new RetrievePIDOutput();
		this.turnController = new PIDController( navKp, navKi, navKd, NAV_X, turnPIDOutput, navXPeriod );
		this.turnController.setInputRange(-180.0f, 180.0f);
        this.turnController.setOutputRange(-1.0, 1.0);
        this.turnController.setAbsoluteTolerance(kToleranceDegrees);
		this.turnController.setContinuous(true);
		this.turnController.enable();
		
		// Smart Dashboard for PID tuning
		LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
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
	
	// Tank drive method
	public void drive( GenericHID left, GenericHID right ){
		this.robotDrive.tankDrive( left, right );
	}
	
	// TODO : Not really sure how this will work with the tank drive
	public void drive( double speed, double turn ){
		this.robotDrive.drive( speed, turn );
	}
	
	// Stop the drive system
	public void reset(){
		this.robotDrive.stopMotor();
		this.robotDrive.free();
	}

	//-------------------------------------- PID Control methods ---------------------------------//
	
	public void setDriveStraightParameters( double distanceSetPoint, double angleToMaintain ){
		distanceController.setSetpoint(distanceSetPoint);
		turnController.setSetpoint(angleToMaintain);
	}
	
	public boolean isStraightDriveFinished() {
		return distanceController.onTarget();
	}
	
	public void drive(){
		this.robotDrive.arcadeDrive( distanceController.get(), turnController.get() );
	}
	
	public PIDController getTurnController(){
		return this.turnController;
	}
	
	public PIDController getDistanceController(){
		return this.distanceController;
	}
}