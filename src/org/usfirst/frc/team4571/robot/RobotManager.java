package org.usfirst.frc.team4571.robot;

import org.usfirst.frc.team4571.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author arjunrao
 *
 */
public final class RobotManager {

	//---------------------------- Subsystems ---------------------------- //
	
	public static final Subsystem ARM_SUBSYSTEM = new ArmSubsystem();
	public static final Subsystem ELEVATOR_SUBSYSTEM = new ElevatorSubsystem();
	public static final Subsystem DRIVE_SUBSYSTEM = new DriveSubsystem();
	
}