package org.usfirst.frc.team4571.robot.commands.autonomous.task;

import edu.wpi.first.wpilibj.Timer;

/**
 * 
 * @author arjunrao87
 *
 */
public class TimeoutTask implements Task {
	
    private double timeout;
    private double startTime;

    public TimeoutTask(double timeout) {
    	this.timeout = timeout;
    }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() >= startTime + timeout;
    }

    @Override
    public void update() {}

    @Override
    public void done() {}

    @Override
    public void start() {
    	this.startTime = Timer.getFPGATimestamp();
    }
}