package org.usfirst.frc.team4571.robot.subsystems.motion;

/**
 * 
 * @author arjunrao87
 *
 */
public class Orientation {

	private double leftDistance;
	private double rightDistance;
	private double leftVelocity;
	private double rightVelocity;
	private double heading;
	private double headingVelocity;

	public Orientation(double leftDistance, double rightDistance, double leftVelocity,
					   double rightVelocity, double heading, double headingVelocity) {
		this.leftDistance = leftDistance;
		this.rightDistance = rightDistance;
		this.leftVelocity = leftVelocity;
		this.rightVelocity = rightVelocity;
		this.heading = heading;
		this.headingVelocity = headingVelocity;
	}
	
	public void reset(double leftDistance, double rightDistance, double leftVelocity,
			          double rightVelocity, double heading, double headingVelocity) {
		this.leftDistance = leftDistance;
		this.rightDistance = rightDistance;
		this.leftVelocity = leftVelocity;
		this.rightVelocity = rightVelocity;
		this.heading = heading;
		this.headingVelocity = headingVelocity;
	}

	public double getLeftDistance() {
		return leftDistance;
	}

	public double getHeading() {
		return heading;
	}

	public double getRightDistance() {
		return rightDistance;
	}

	public double getLeftVelocity() {
		return leftVelocity;
	}

	public double getRightVelocity() {
		return rightVelocity;
	}

	public double getHeadingVelocity() {
		return headingVelocity;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Orientation))
			return false;
		if (obj == this)
			return true;
		Orientation otherPose = (Orientation) obj;
		return otherPose.getLeftDistance() == getLeftDistance()
				&& otherPose.getRightDistance() == getRightDistance()
				&& otherPose.getLeftVelocity() == getLeftVelocity()
				&& otherPose.getRightVelocity() == getRightVelocity()
				&& otherPose.getHeading() == getHeading()
				&& otherPose.getHeadingVelocity() == getHeadingVelocity();
	}

	@Override
	public String toString() {
		return "Orientation [leftDistance=" + leftDistance + ", rightDistance="
				+ rightDistance + ", leftVelocity=" + leftVelocity
				+ ", rightVelocity=" + rightVelocity + ", heading=" + heading
				+ ", headingVelocity=" + headingVelocity + "]";
	}
}