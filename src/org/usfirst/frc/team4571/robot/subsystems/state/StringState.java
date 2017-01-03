package org.usfirst.frc.team4571.robot.subsystems.state;

/**
 * Helper class for storing String as state
 * 
 * @author arjunrao87
 *
 */
public class StringState extends State<String>{

	public StringState( StateKey key ) {
		super(key);
	}
	
	public StringState( StateKey key, String value ){
		super( key, value );
	}
}