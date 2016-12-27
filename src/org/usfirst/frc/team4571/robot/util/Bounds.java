package org.usfirst.frc.team4571.robot.util;

/**
 * Defines the min, max and home positions for a particular movement
 * 
 * @author arjunrao87
 *
 * @param <T>
 */
public class Bounds<T> {

	private final T minPosition;
	private final T maxPosition;
	private final T homePosition;
	
	public Bounds( T minPosition, T maxPosition, T homePosition ){
		this.minPosition  = minPosition;
		this.maxPosition  = maxPosition;
		this.homePosition = homePosition;
	}
	
	public T getMinPosition() {
		return minPosition;
	}
	public T getMaxPosition() {
		return maxPosition;
	}
	public T getHomePosition() {
		return homePosition;
	}
}