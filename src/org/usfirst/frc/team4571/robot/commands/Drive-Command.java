/*©Copyright 2016 Team 4571 FRC
* Author: Mohammed A. Ajao
* Description: The drive command for the CrateRobot in its beta phase using the WPILib.
*/

package org.usfirst.frc.team4571.robot.commands;

//--Custom Classes--\\
import org.usfirst.frc.team4571.robot.RobotMap;
import org.usfirst.frc.team4571.robot.subsystems.Driving;

//--Winchester Polytech Institute Library--\\
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drive extends Command
{
	private Driving m_Subsystem = new Driving();
	private Joystick m_Joystick = new Joystick(RobotMap.JOYSTICK_CHANNEL);
	private RobotDrive m_RobotDrive = new RobotDrive(RobotMap.FRONT_LEFT_MOTOR_CHANNEL,
			RobotMap.REAR_LEFT_MOTOR_CHANNEL,
			RobotMap.FRONT_RIGHT_MOTOR_CHANNEL,
			RobotMap.REAR_RIGHT_MOTOR_CHANNEL);

	protected void initialize() {
	}

	protected void execute() 
	{
		// TODO Auto-generated method stub
		m_RobotDrive.arcadeDrive(m_Joystick, true);
		m_RobotDrive.mecanumDrive_Polar(m_Joystick.getMagnitude(), m_Joystick.getDirectionDegrees(), m_Joystick.getX());
		/*m_RobotDrive.mecanumDrive_Cartesian(m_Joystick.getX(), 
				m_Joystick.getY(), 
				m_Joystick.getTwist(), gyroAngle);*/
		//Cartesian is just a test seeing that it was implemented into the original crate robot code.
		//GyroAngle requires us to make a Gyro class extending GyroBase - which requires math...
		//I decided not to code it since PID seems to be a much larger topic and wanted to simplify the code.
	}

	protected boolean isFinished() 
	{return false;}
	
	protected void end() 
	{
		// TODO Auto-generated method stub
		m_RobotDrive.stopMotor();
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	public Drive()
	{
		requires(m_Subsystem);
	}

}
