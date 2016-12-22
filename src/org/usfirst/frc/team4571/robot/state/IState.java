package org.usfirst.frc.team4571.robot.state;

/**
 * Rough sketch of what state should look like
 * 
 * @author arjunrao87
 *
 * @param <Value> : Type of state
 */
public interface IState<Value> {

	public String getStateName();
	
	public Value getValue();
	
	public String toJSON();
	
}