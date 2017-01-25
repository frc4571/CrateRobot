package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RambotsConstants;
import org.usfirst.frc.team4571.robot.subsystems.sensors.AverageDistanceEncoder;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class DrivePIDSubsystem extends PIDSubsystem {

	private final SpeedController frontLeftSpeedController  = new CANTalon(RambotsConstants.FRONT_LEFT_TALON_CHANNEL);
	private final SpeedController frontRightSpeedController = new CANTalon(RambotsConstants.FRONT_RIGHT_TALON_CHANNEL);
	private final SpeedController rearLeftSpeedController   = new CANTalon(RambotsConstants.REAR_LEFT_TALON_CHANNEL);
	private final SpeedController rearRightSpeedController  = new CANTalon(RambotsConstants.REAR_RIGHT_TALON_CHANNEL);
	private static final AHRS NAV_X = new AHRS(SPI.Port.kMXP);

	private final RobotDrive robotDrive;
	private final AverageDistanceEncoder averageDistanceEncoder;
	private final PIDController distanceController;
	
	private double speed;

	public DrivePIDSubsystem( double p, double i, double d ) {
		super(p, i, d);
		this.robotDrive = new RobotDrive(frontLeftSpeedController, rearLeftSpeedController, frontRightSpeedController, rearRightSpeedController);
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
		
		this.distanceController = new PIDController(1, 0, 0, averageDistanceEncoder, new PIDOutput() {

			@Override
			public void pidWrite(double output) {
				speed = output;
			}
		});
	}
	
	public void setDriveParameters( double distanceSetPoint, double angleToMaintain ){
		// Step 1 : Reset Sensors
		averageDistanceEncoder.reset();
		distanceController.reset();
		getPIDController().reset();
		
		// Step 2 : Initialize distance controller
		distanceController.setInputRange(0, distanceSetPoint);
		distanceController.setOutputRange(-1, 1);
		distanceController.setSetpoint(distanceSetPoint);
		distanceController.setPercentTolerance(5.0);
		distanceController.setContinuous(false);
		
		// Step 3 : Initialize turn controller
		getPIDController().setSetpoint(angleToMaintain);
		getPIDController().setInputRange(-180.0f, 180.0f);
		getPIDController().setOutputRange(-1.0, 1.0);
		getPIDController().setAbsoluteTolerance(2.0f);
		getPIDController().setContinuous(true);
		
		// Step 4 : Enable PID Controllers
		distanceController.enable();
		getPIDController().enable();
	}

	public void drive( double speed, double turn ){
		this.robotDrive.arcadeDrive(speed, turn);
	}
	
	public void tankDrive( double left, double right ){
		if( !distanceController.onTarget() )
			this.robotDrive.tankDrive(left, right);
	}
		
	@Override
	protected double returnPIDInput() {
		return NAV_X.getAngle();
	}

	//https://www.chiefdelphi.com/forums/showthread.php?t=114061
	@Override
	protected void usePIDOutput(double output) {
		tankDrive( speed + output, speed - output );
	}

	public boolean isFinished(){
		return distanceController.onTarget() && getPIDController().onTarget();
	}
	
	@Override
	protected void initDefaultCommand() {}
}