package org.usfirst.frc.team4571.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Basic definition for teleop commands
 * 
 * @author arjunrao87
 *
 */
public abstract class AbstractTeleopCommand extends Command {
	
	private String commandName;
	
	public AbstractTeleopCommand(){}
	
	public AbstractTeleopCommand( String commandName ){
		this.commandName = commandName;
	}
	
	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
	
	@Override
	public String getName(){
		return this.commandName;
	}
}