package org.usfirst.frc.team4571.robot.subsystems.navigator;

import edu.wpi.first.wpilibj.Timer;


/**
 * Deceleration navigator. Given certain time period of deceleration, it alters the speed of the required motors 
 * within that time to the "endPower" value
 * 
 * @author arjunrao87
 *
 */
public class TimedNavigator extends AbstractNavigator {

	private double startTimeOfControlLoop;
	private double startTimeOfDecelerate;
	private double endTimeOfDecelerate;
	private double startPower;
	private double endPower;

	public TimedNavigator(double startPower, double timeFullOn, double endPower, double timeToDecelerate) {
		this.startTimeOfControlLoop = Timer.getFPGATimestamp();
		this.startTimeOfDecelerate = startTimeOfControlLoop + timeFullOn;
		this.endTimeOfDecelerate = startTimeOfDecelerate + timeToDecelerate;
		this.startPower = startPower;
		this.endPower = endPower;
	}

	public boolean expired() {
		return Timer.getFPGATimestamp() > endTimeOfDecelerate;
	}

	public double update() {
		double currentTime = Timer.getFPGATimestamp();
		if (currentTime <= startTimeOfDecelerate) {
			return startPower;
		} else if (currentTime > startTimeOfDecelerate && currentTime <= endTimeOfDecelerate) {
			// Deceleration
			double rel_t = currentTime - startTimeOfDecelerate;
			double slope = (endPower - startPower) / (endTimeOfDecelerate - startTimeOfDecelerate);
			return (startPower + (slope * rel_t));
		} else {
			return endPower;
		}
	}

	@Override
	public void reset() {
		startTimeOfControlLoop = startTimeOfDecelerate = endTimeOfDecelerate = endPower = startPower = 0;
	}

	@Override
	public boolean isOnTarget() {
		return expired();
	}
}