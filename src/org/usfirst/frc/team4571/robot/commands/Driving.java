package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Joystick1;
import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Driving extends Command{
	
	
	

	public Driving(boolean b, boolean forward1, int sds1) {
		requires(Robot.drivesystem);
		
		
	}

	@Override
	protected void initialize() {
		
	Robot.drivesystem.intializeSubSystem();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		driveforward();
	}
	public void driveforward(){
		Robot.drivesystem.Mdrive(Robot.joystick1.getX(), Robot.joystick1.getY(), Robot.joystick1.getZ());
		
	}
	@Override
	protected void end() {

		
	}

	protected boolean isFinished() {
		
		return false;
	}

	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
