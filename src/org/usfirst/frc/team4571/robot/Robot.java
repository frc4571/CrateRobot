package org.usfirst.frc.team4571.robot;

import jaci.openrio.toast.lib.module.IterativeModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc.team4571.robot.commands.teleop.SimpleTeleopElevatorDownCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.SimpleTeleopElevatorUpCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.TeleopArmCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.TeleopElevatorStopCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.TeleopSweepCommand;
import org.usfirst.frc.team4571.robot.components.LimitSwitch;
import org.usfirst.frc.team4571.robot.components.RambotsJoystick;
import org.usfirst.frc.team4571.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.OverallArmSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.SweepSubsystem;
import org.usfirst.frc.team4571.robot.web.RobotWebServer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * 
 * @author arjunrao87
 *
 */
public class Robot extends IterativeModule {
	
	/**
	 * Tells what the current mode of the robot is
	 * 
	 * @author arjunrao
	 *
	 */
	public enum RobotMode {
		
		AUTONOMOUS,
		TELEOP,
		DISABLED

	}
	
	//======================= SUBSYSTEM MANAGEMENT ===================//

	// Subsystems
	public static final OverallArmSubsystem OVERALL_ARM_SUBSYSTEM = new OverallArmSubsystem();
	public static final ElevatorSubsystem ELEVATOR_SUBSYSTEM = new ElevatorSubsystem();
	public static final DriveSubsystem DRIVE_SUBSYSTEM       = new DriveSubsystem();
	public static final ArmSubsystem ARM_SUBSYSTEM         = new ArmSubsystem();
	public static final SweepSubsystem SWEEP_SUBSYSTEM       = new SweepSubsystem();
	
	//========================== COMPONENT MANAGEMENT ================//
	
	// Joystick
	public static final RambotsJoystick JOYSTICK = new RambotsJoystick(NetworkMapping.JOYSTICK_CHANNEL);
	
	// Limit switches
	public static final LimitSwitch LEFT_ARM_UP_SWITCH    = new LimitSwitch( NetworkMapping.LEFT_ARM_UP_SWITCH_CHANNEL );
	public static final LimitSwitch LEFT_ARM_DOWN_SWITCH  = new LimitSwitch( NetworkMapping.LEFT_ARM_DOWN_SWITCH_CHANNEL );
	public static final LimitSwitch RIGHT_ARM_UP_SWITCH   = new LimitSwitch( NetworkMapping.RIGHT_ARM_UP_SWITCH_CHANNEL );
	public static final LimitSwitch RIGHT_ARM_DOWN_SWITCH = new LimitSwitch( NetworkMapping.RIGHT_ARM_DOWN_SWITCH_CHANNEL );
	
	// Web server
	public static final RobotWebServer WEB_SERVER = new RobotWebServer();
	
	//============================= COMMAND MANAGEMENT ================//
	
	// TeleOp commands
	public static final Command SIMPLE_TELEOP_ELEVATOR_UP = new SimpleTeleopElevatorUpCommand();
	public static final Command TELEOP_ELEVATOR_STOP = new TeleopElevatorStopCommand();
	public static final Command SIMPLE_TELEOP_ELEVATOR_DOWN = new SimpleTeleopElevatorDownCommand();
	public static final Command TELEOP_SWEEP = new TeleopSweepCommand();
	public static final Command TELEOP_ARM = new TeleopArmCommand();
	
	// Autonomous commands
	
	//===================== Robot instance variables ===================//
	
	private static final Logger logger = LoggerFactory.getLogger(Robot.class);
	private RobotMode robotMode;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	@Override
    public void robotInit() {
		logger.info( "Starting up robot!" );
    	JOYSTICK.buttonAWhenPressed(TELEOP_ARM)
    			.buttonBWhenPressed(TELEOP_SWEEP)
    			.buttonXWhenPressed(SIMPLE_TELEOP_ELEVATOR_UP)
    			.buttonXWhenReleased(TELEOP_ELEVATOR_STOP)
    			.buttonYWhenPressed(SIMPLE_TELEOP_ELEVATOR_DOWN)
    			.buttonYWhenReleased(TELEOP_ELEVATOR_STOP);
    	WEB_SERVER.start(4571);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    @Override
    public void disabledInit(){
    	this.robotMode = RobotMode.DISABLED;
    	logger.info( "Robot mode initialized - " + robotMode );
    	
    	ARM_SUBSYSTEM.resetArmSolenoid();
    	SWEEP_SUBSYSTEM.resetSweeperSolenoid();
    	DRIVE_SUBSYSTEM.reset();
    	ELEVATOR_SUBSYSTEM.stop();
    }
	
    @Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 */
    @Override
    public void autonomousInit() {
    	this.robotMode = RobotMode.AUTONOMOUS;
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
    	this.robotMode = RobotMode.TELEOP;
    	logger.info( "Robot mode initialized - " + robotMode );
    	
    	SIMPLE_TELEOP_ELEVATOR_UP.start();
    	SIMPLE_TELEOP_ELEVATOR_DOWN.start();
    	TELEOP_ELEVATOR_STOP.start();
    	TELEOP_ARM.start();
    	TELEOP_SWEEP.start();
    	System.err.println( "teleopInit");
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    	logger.info( "Running " + robotMode + " periodically." );
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
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
    
    public RobotMode getRobotMode(){
    	return this.robotMode;
    }
}