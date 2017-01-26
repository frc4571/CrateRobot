package org.usfirst.frc.team4571.robot.commands.autonomous.group;

import org.usfirst.frc.team4571.robot.commands.autonomous.DriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 * @author arjunrao87
 *
 */
public class BackAndForthCommand extends CommandGroup{
	
	public BackAndForthCommand(){
		
		// Move ahead 2 feet
		addSequential(new DriveCommand(24, 0));
		
		// Move behind 2 feet
		addSequential(new DriveCommand(-24, 0));
		
		// Move ahead 3 feet at 45 degrees
		addSequential(new DriveCommand(36, 45));
				
		// Move behind 3 feet at 45 degrees
		addSequential(new DriveCommand(-36, 45));
	}
}