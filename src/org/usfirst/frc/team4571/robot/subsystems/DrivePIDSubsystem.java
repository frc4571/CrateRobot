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
import edu.wpi.first.wpilibj.PIDSourceType;
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
	private final SpeedController frontLeftSpeedController  = new CANTalon(RambotsConstants.FRONT_LEFT_TALON_CHANNEL);
	private final SpeedController frontRightSpeedController = new CANTalon(RambotsConstants.FRONT_RIGHT_TALON_CHANNEL);
	private final SpeedController rearLeftSpeedController   = new CANTalon(RambotsConstants.REAR_LEFT_TALON_CHANNEL);
	private final SpeedController rearRightSpeedController  = new CANTalon(RambotsConstants.REAR_RIGHT_TALON_CHANNEL);
	
	/**
	 * Sensors
	 */
	//Encoders
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
		this.robotDrive = new RobotDrive(frontLeftSpeedController, rearLeftSpeedController, frontRightSpeedController, rearRightSpeedController);
		
		//Invert right side
		this.robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		this.robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		//Set safety
		this.robotDrive.setSafetyEnabled(true);
		this.robotDrive.setSensitivity(0.75);
		this.robotDrive.setMaxOutput(0.95);
		
		// Set up Encoders
		Encoder driveTrainLeftEncoder = new Encoder( RambotsConstants.LEFT_DRIVE_TRAIN_ENCODER_CHANNEL_A,
													 RambotsConstants.LEFT_DRIVE_TRAIN_ENCODER_CHANNEL_B,
													 true,
													 EncodingType.k4X );
		driveTrainLeftEncoder.setDistancePerPulse( RambotsConstants.ENCODER_DISTANCE_PER_PULSE );
		driveTrainLeftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		driveTrainLeftEncoder.setSamplesToAverage(10);
		driveTrainLeftEncoder.setMaxPeriod(0.1);
		driveTrainLeftEncoder.setMinRate(10);
		Encoder driveTrainRightEncoder = new Encoder( RambotsConstants.RIGHT_DRIVE_TRAIN_ENCODER_CHANNEL_A,
														 RambotsConstants.RIGHT_DRIVE_TRAIN_ENCODER_CHANNEL_B,
														 true,
														 EncodingType.k4X );
		driveTrainRightEncoder.setDistancePerPulse( RambotsConstants.ENCODER_DISTANCE_PER_PULSE );
		driveTrainRightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		driveTrainRightEncoder.setSamplesToAverage(10);
		driveTrainRightEncoder.setMaxPeriod(0.1);
		driveTrainRightEncoder.setMinRate(10);
		
		this.averageDistanceEncoder = new AverageDistanceEncoder(driveTrainLeftEncoder, driveTrainRightEncoder);

		// Set up PID Controllers
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
		
		// Smart Dashboard for PID tuning
		LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
	}
	
	public void initializeSubsystem(){	
		frontLeftSpeedController.set(0.0);
		frontRightSpeedController.set(0.0);
		rearLeftSpeedController.set(0.0);
		rearRightSpeedController.set(0.0);
		averageDistanceEncoder.reset();
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
		averageDistanceEncoder.reset();
		turnController.reset();
		distanceController.setInputRange(0, distanceSetPoint);
		distanceController.setOutputRange(-1, 1);
		distanceController.setSetpoint(distanceSetPoint);
		turnController.setSetpoint(angleToMaintain);
		distanceController.enable();
		turnController.enable();
	}
	
	/**
	 * Distance you want to traverse
	 * @param distanceSetPoint
	 */
	public void drive( double distanceInInches ){
		setDriveStraightParameters( distanceInInches, 0 );
		while( distanceController.onTarget() ){
			this.robotDrive.arcadeDrive( distanceController.get(), 0 );
		}
	}
	
	public boolean isStraightDriveFinished() {
		return distanceController.onTarget() && turnController.onTarget();
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