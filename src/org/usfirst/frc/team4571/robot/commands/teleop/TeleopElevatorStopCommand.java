package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

public class TeleopElevatorStopCommand extends AbstractTeleopCommand {

	@Override
	protected void initialize() {
		requires( Robot.ELEVATOR_SUBSYSTEM );
	}

	@Override
	protected void execute() {
		Robot.ELEVATOR_SUBSYSTEM.stop();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}