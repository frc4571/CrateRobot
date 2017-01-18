package org.usfirst.frc.team4571.robot.subsystems.state;

import edu.wpi.first.wpilibj.Timer;

/**
 * 
 * @author arjunrao87
 *
 * @param <T>
 */
public class State<T> {

	private StateKey key;
	private T value;

	public State( StateKey key ){
		this.key = key;
	}
	
	public State( StateKey key, T value ){
		this.key = key;
		this.value = value;
	}	
	
	public void setValue( T value ){
		this.value = value;
	}
	
	public StateKey getKey(){
		return this.key;
	}
	
	public T getValue(){
		return this.value;
	}
	
	@Override
	public String toString() {
		return "State [key=" + key + ", value=" + value + "]";
	}
	
	/**
	 * 
	 * @author arjunrao87
	 *
	 */
	public static class StateKey{
		
		private static final String DEFAULT_MODULE = "Rambots";
		private final String module;
		private final String stateName;
		private final double asOfTime;
		
		public StateKey( String module, String stateName, double asOfTime ){
			this.module    = module;
			this.stateName = stateName;
			this.asOfTime  = asOfTime;
		}
		
		public String getModule() {
			return module;
		}
		
		public String getStateName() {
			return stateName;
		}
		
		public double getAsOfTime() {
			return asOfTime;
		}
		
		public static StateKey getKey( String stateName ){
			return new StateKey( DEFAULT_MODULE, stateName, Timer.getFPGATimestamp() );
		}
		
		public static StateKey getKey( String module, String stateName ){
			return new StateKey( module, stateName, Timer.getFPGATimestamp() );
		}

		@Override
		public String toString() {
			return "StateKey [module=" + module + ", stateName=" + stateName
					+ ", asOfTime=" + asOfTime + "]";
		}
	}
}