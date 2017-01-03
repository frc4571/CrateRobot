package org.usfirst.frc.team4571.robot.subsystems.modules;

import java.util.Collection;

import org.usfirst.frc.team4571.robot.subsystems.motion.Actions;
import org.usfirst.frc.team4571.robot.subsystems.motion.Bounds;
import org.usfirst.frc.team4571.robot.subsystems.motion.Orientation;
import org.usfirst.frc.team4571.robot.subsystems.navigator.AbstractNavigator;
import org.usfirst.frc.team4571.robot.subsystems.state.State;

/**
 * 
 * @author arjunrao87
 *
 */
public interface SubsystemModule {

	public Collection<AbstractNavigator> getNavigators();
	
	public Bounds<?> getBounds();
	
	public Collection<State<?>> getState();
	
	public Orientation getOrientation();
	
	public Actions getActions();
		
}