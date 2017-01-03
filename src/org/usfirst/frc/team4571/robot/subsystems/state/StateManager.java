package org.usfirst.frc.team4571.robot.subsystems.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.usfirst.frc.team4571.robot.subsystems.state.State.StateKey;

/**
 * Manages all robot state
 * 
 * @author arjunrao87
 *
 */
public class StateManager {

	private Map<StateKey, State<?>> states;
	
	public StateManager(){
		this.states = new HashMap<>();
	}

	public void put(StateKey key, State<?> value) {
	}

	public State<?> get(String key) {
		return states.get(key);
	}

	public Set<StateKey> keySet() {
		return states.keySet();
	}
}