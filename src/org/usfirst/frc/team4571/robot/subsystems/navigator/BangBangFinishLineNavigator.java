package org.usfirst.frc.team4571.robot.subsystems.navigator;


/**
 * 
 * @author arjunrao87
 *
 */
public class BangBangFinishLineNavigator extends AbstractNavigator {

    private double position;
    private double goal;
    private double tolerance;
    private double direction = 0.0;

    public BangBangFinishLineNavigator(double tolerance) {
        this.tolerance = tolerance;
    }

    public void setGoal(double goal) {
    	this.goal = goal;
    }

    public double getGoal() {
        return goal;
    }

    @Override
    public void reset() {
        direction = 0.0;
    }

    @Override
    public boolean isOnTarget() {
        if (direction == 0.0) {
            return false;
        }
        return (direction > 0 ? position > (goal - tolerance)
                : position < (goal + tolerance));
    }

    public double update(double position) {
        if (direction == 0.0) {
            direction = (position > goal ? -1.0 : 1.0);
        }
        this.position = position;
        if (direction > 0) {
            if (position < (goal - tolerance)) {
                return 1.0;
            } else {
                return 0.0;
            }
        } else {
            if (position > (goal + tolerance)) {
                return -1.0;
            } else {
                return 0.0;
            }
        }
    }
}