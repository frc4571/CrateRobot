package org.usfirst.frc.team4571.robot.subsystems;
import org.usfirst.frc.team4571.robot.RobotMap;
import org.usfirst.frc.team4571.robot.commands.Driving;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;

public class DriveSystem  extends Subsystem{
public RobotDrive robotdrive;
public final TalonSRX frontLeftChannel = new TalonSRX(RobotMap.frontLeftChannel);
public final TalonSRX secondtofrontLeftChannel = new TalonSRX(RobotMap.secondtofrontleftChannel);
public final TalonSRX frontRightChannel = new TalonSRX (RobotMap.frontRightChannel);
public final TalonSRX secondtofrontRightChannel = new TalonSRX(RobotMap.secondtofrontRightChannel);
	

public DriveSystem (){
	super("drive!");
	robotdrive = new RobotDrive(RobotMap.frontLeftChannel, RobotMap.secondtofrontleftChannel, RobotMap.frontRightChannel, RobotMap.secondtofrontRightChannel);
	
	
	
	robotdrive.setExpiration(0.1); 
	robotdrive.setSafetyEnabled(true);

}
public void intializeSubSystem (){
	
	 frontLeftChannel.set(0.5);
	 secondtofrontLeftChannel.set(0.5);
	 frontRightChannel.set(0.5);
	 secondtofrontRightChannel.set(0.5);



}
public void Mdrive( double sides, double forward, double rotating){
	robotdrive.mecanumDrive_Cartesian( sides, forward, rotating, 0);
	
}
@Override
protected void initDefaultCommand() {
	// TODO Auto-generated method stub
	
}

}
