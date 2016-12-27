package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RambotsConstants;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao87
 *
 */
public class DriveSubsystem extends Subsystem {

	private static final SpeedController FRONT_LEFT_SPEED_CONTROLLER  = new TalonSRX(RambotsConstants.FRONT_LEFT_TALON_CHANNEL);
	private static final SpeedController FRONT_RIGHT_SPEED_CONTROLLER = new TalonSRX(RambotsConstants.FRONT_RIGHT_TALON_CHANNEL);
	private static final SpeedController REAR_LEFT_SPEED_CONTROLLER   = new TalonSRX(RambotsConstants.REAR_LEFT_TALON_CHANNEL);
	private static final SpeedController REAR_RIGHT_SPEED_CONTROLLER  = new TalonSRX(RambotsConstants.REAR_RIGHT_TALON_CHANNEL);
	
	private RobotDrive robotDrive;
	
	public DriveSubsystem(){
		this.robotDrive = new RobotDrive(FRONT_LEFT_SPEED_CONTROLLER, REAR_LEFT_SPEED_CONTROLLER, FRONT_RIGHT_SPEED_CONTROLLER, REAR_RIGHT_SPEED_CONTROLLER);
		this.robotDrive.setSafetyEnabled(true);
		this.robotDrive.setSensitivity(0.75);
		this.robotDrive.setMaxOutput(0.95);
	}
	
	public void initializeSubsystem(){	
		FRONT_LEFT_SPEED_CONTROLLER.set(0.0);
		FRONT_RIGHT_SPEED_CONTROLLER.set(0.0);
		REAR_LEFT_SPEED_CONTROLLER.set(0.0);
		REAR_RIGHT_SPEED_CONTROLLER.set(0.0);
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
}