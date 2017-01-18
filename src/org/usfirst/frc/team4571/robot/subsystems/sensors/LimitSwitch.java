package org.usfirst.frc.team4571.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Limit switch class to map to a digital limit switch sensor
 * Uses a counter to track state of the switch
 * 
 * @author arjunrao87
 *
 */
public class LimitSwitch {

	private DigitalInput limitSwitch;
	private Counter counter;
	
	public LimitSwitch( int switchChannel ){
		this.limitSwitch = new DigitalInput(switchChannel);
		this.counter = new Counter( limitSwitch );
	}

	/**
	 * Get the raw value of the counter
	 * 
	 * @return counter value
	 */
	public int getVal(){
		return this.counter.get();
	}
	
	/**
	 * Is the limit switch on or off?
	 * 
	 * @return state of the limit switch
	 */
	public boolean isSet(){
		return this.counter.get() > 0;
	}
	
	public void reset(){
		this.counter.reset();
	}
}