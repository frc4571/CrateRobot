package org.usfirst.frc.team4571.robot.subsystems.navigator;

/**
 * 
 * @author arjunrao87
 *
 */
public abstract class AbstractNavigator {
	
    protected boolean enabled;

    public abstract void reset();

    public abstract boolean isOnTarget();
}