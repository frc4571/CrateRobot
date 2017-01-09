package org.usfirst.frc.team4571.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CommandArms extends Command {

    public CommandArms() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(ArmSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
            if(DriverStick.getRawButton(1) == true)
            {
                  s1.set(true);
                  s2.set(false);
             }
             if(DriverStick.getRawButton(2) == true)
             {
                  s1.set(false);
                  s2.set(true);
              }
      }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
