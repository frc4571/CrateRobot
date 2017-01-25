package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RambotsConstants;
import org.usfirst.frc.team4571.robot.subsystems.sensors.AverageDistanceEncoder;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author arjunrao87
 *
 */
public class DriveSubsystem extends Subsystem{

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
	private double encoderKp = 1.0;
	private double encoderKi = 0.0;
	private double encoderKd = 0.0;
	
	// NavX
	private static final AHRS NAV_X = new AHRS(SPI.Port.kMXP);
	private double navKp = 1.0;
	private double navKi = 0.0;
	private double navKd = 0.0;
	private final double kToleranceDegrees = 2.0f;
	
	// PIDSource, PIDOutput
	private final AverageDistanceEncoder averageDistanceEncoder;
	
	// PID Controllers
	private final PIDController distanceController;
	private final PIDController turnController;
	
	/**
	 * Robot Drive
	 */
	private RobotDrive robotDrive;
	
	// SmartDashboard parameters
	private static final String DISTANCE_TRAVELED 				= "DriveSubsystem : Average Encoder Distance Reading : ";
	private static final String TURN_CONTROLLER_READING 		= "DriveSubsystem : Turn Controller Reading : ";
	protected static final String LEFT_TANK_DRIVE_MOTOR_SPEED 	= "DriveSubsystem : Left Tank Drive Motor Speed : ";
	protected static final String RIGHT_TANK_DRIVE_MOTOR_SPEED 	= "DriveSubsystem : Right Tank Drive Motor Speed : ";	
	protected static final String TURN_CONTROLLER_PID_WRITE   	= "TurnController PIDWrite";
	protected static final String DISTANCE_CONTROLLER_PID_WRITE = "DistanceController PIDWrite";
	
	public DriveSubsystem(){
		// Robot Drive
		this.robotDrive = new RobotDrive(frontLeftSpeedController, rearLeftSpeedController, frontRightSpeedController, rearRightSpeedController);
		
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
													  false,
													  EncodingType.k4X );
		driveTrainRightEncoder.setDistancePerPulse( RambotsConstants.ENCODER_DISTANCE_PER_PULSE );
		driveTrainRightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		driveTrainRightEncoder.setSamplesToAverage(10);
		driveTrainRightEncoder.setMaxPeriod(0.1);
		driveTrainRightEncoder.setMinRate(10);
		
		this.averageDistanceEncoder = new AverageDistanceEncoder(driveTrainLeftEncoder, driveTrainRightEncoder);

		// Set up PID Controllers
		this.distanceController = new PIDController(encoderKp, encoderKi, encoderKd, averageDistanceEncoder, new PIDOutput() {
			
			@Override
			public void pidWrite(double output) {
				double turnOutput = turnController.get();
				robotDrive.tankDrive( output + turnOutput, output - turnOutput );
				SmartDashboard.putNumber( TURN_CONTROLLER_READING 	   + DISTANCE_CONTROLLER_PID_WRITE, turnOutput );
				SmartDashboard.putNumber( LEFT_TANK_DRIVE_MOTOR_SPEED  + DISTANCE_CONTROLLER_PID_WRITE, output + turnOutput );
				SmartDashboard.putNumber( RIGHT_TANK_DRIVE_MOTOR_SPEED + DISTANCE_CONTROLLER_PID_WRITE, output - turnOutput  );
				SmartDashboard.putNumber( DISTANCE_TRAVELED, averageDistanceEncoder.getDistance() );
			}
		});
		
		this.turnController = new PIDController( navKp, navKi, navKd, NAV_X, new PIDOutput(){

			@Override
			public void pidWrite(double output) {
				SmartDashboard.putNumber( TURN_CONTROLLER_READING + TURN_CONTROLLER_PID_WRITE, output );
			}
		});

		// Smart Dashboard for PID tuning
		LiveWindow.addActuator("DriveSystem", "DistanceController", distanceController);
		LiveWindow.addActuator("DriveSystem", "TurnController"    , turnController);
	}

	//------------------------------------------ Required definitions ------------------------------------//
	
	@Override
	protected void initDefaultCommand() {
		// No default command
	}
	
	public void initializeSubsystem(){	
		frontLeftSpeedController.set(0.0);
		frontRightSpeedController.set(0.0);
		rearLeftSpeedController.set(0.0);
		rearRightSpeedController.set(0.0);
		averageDistanceEncoder.reset();
		NAV_X.reset();
	}
	
	public void reset(){
		this.robotDrive.stopMotor();
		this.robotDrive.free();
	}

	//-------------------------------------- Drive methods ---------------------------------//
	
	public void drive( GenericHID left, GenericHID right ){
		this.robotDrive.tankDrive( left, right );
	}

	//-------------------------------------- PID Control methods ---------------------------------//
	
	public void setDriveParameters( double distanceSetPoint, double angleToMaintain ){
		// Step 1 : Reset Sensors
		averageDistanceEncoder.reset();
		distanceController.reset();
		turnController.reset();
		
		// Step 2 : Initialize distance controller
		distanceController.setInputRange(0, distanceSetPoint);
		distanceController.setOutputRange(-1, 1);
		distanceController.setSetpoint(distanceSetPoint);
		distanceController.setPercentTolerance(5.0);
		distanceController.setContinuous(false);
		
		// Step 3 : Initialize turn controller
		turnController.setSetpoint(angleToMaintain);
		turnController.setInputRange(-180.0f, 180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
		turnController.setContinuous(true);
		
		// Step 4 : Enable PID Controllers
		distanceController.enable();
		turnController.enable();
	}

	public boolean isFinished() {
		return distanceController.onTarget() && turnController.onTarget();
	}

	public PIDController getTurnController(){
		return this.turnController;
	}
	
	public PIDController getDistanceController(){
		return this.distanceController;
	}	
}