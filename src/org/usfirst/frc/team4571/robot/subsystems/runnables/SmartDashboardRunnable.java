package org.usfirst.frc.team4571.robot.subsystems.runnables;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * 
 * @author arjunrao87
 *
 */
public class SmartDashboardRunnable implements Runnable, Component<SmartDashboard> {

	private SmartDashboard dashboard;
	
	@Override
	public SmartDashboard getComponent() {
		return dashboard;
	}

	@Override
	public void run() {
	}
}
