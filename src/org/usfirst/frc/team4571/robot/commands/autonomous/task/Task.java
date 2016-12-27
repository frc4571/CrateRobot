package org.usfirst.frc.team4571.robot.commands.autonomous.task;

/**
 * 
 * @author arjunrao87
 *
 */
public interface Task {

    public boolean isFinished();

    public void update();

    public void done();

    public void start();
}