package org.usfirst.frc.team4571.robot.commands.autonomous.mode;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pick autonomous modes to run via smart dashboard
 * 
 * @author arjunrao87
 *
 */
public final class AutonomousModePicker {

	protected static final String AUTONOMOUS_MODE = "Autonomous Mode";
	
	private Map<String, CommandGroup> modes;
	
	public AutonomousModePicker(){
		this.setModes(new HashMap<>());
		modes = new HashMap<>();
	    addAutoCommand("None", new CommandGroup());
	}

	public void addAutoCommand(String name, CommandGroup command) {
		modes.put(name, command);
	}

	public Map<String, CommandGroup> getModes() {
		return modes;
	}

	public void setModes(Map<String, CommandGroup> modes) {
		this.modes = modes;
	}
}