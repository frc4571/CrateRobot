package org.usfirst.frc.team4571.robot;

import jaci.openrio.toast.lib.module.IterativeModule;

import org.usfirst.frc.team4571.robot.components.RambotsJoystick;
import org.usfirst.frc.team4571.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.GrabSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.SweepSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * 
 * @author arjunrao87
 *
 */
public class Robot extends IterativeModule {
	
	//======================= RESOURCE MANAGEMENT ===================//

	// Subsystems
	public static final ArmSubsystem ARM_SUBSYSTEM           = new ArmSubsystem();
	public static final ElevatorSubsystem ELEVATOR_SUBSYSTEM = new ElevatorSubsystem();
	public static final DriveSubsystem DRIVE_SUBSYSTEM       = new DriveSubsystem();
	public static final GrabSubsystem GRAB_SUBSYSTEM         = new GrabSubsystem();
	public static final SweepSubsystem SWEEP_SUBSYSTEM       = new SweepSubsystem();
	
	// Joystick
	public static final RambotsJoystick JOYSTICK = new RambotsJoystick(NetworkMapping.JOYSTICK_CHANNEL);
	
	//=================================================================//
	
    private Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 */
    public void autonomousInit() {
        if (autonomousCommand != null) {
        	autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * TeleOp initialization
     */
    public void teleopInit() {
        if (autonomousCommand != null) {
        	autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    @Override
    public String getModuleName() {
        return "CrateRobot";
    }

    @Override
    public String getModuleVersion() {
        return "1.0.0";
    }
}