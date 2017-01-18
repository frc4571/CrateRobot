package org.usfirst.frc.team4571.robot.subsystems.state;

/**
 * Helper class for storing Number as state
 * 
 * @author arjunrao87
 *
 */
public class NumberState extends State<Number>{

	public NumberState( StateKey key ) {
		super(key);
	}
	
	public NumberState( StateKey key, Number value ){
		super( key, value );
	}
}