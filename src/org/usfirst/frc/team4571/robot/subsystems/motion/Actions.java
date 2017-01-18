package org.usfirst.frc.team4571.robot.subsystems.motion;

/**
 * 
 * @author arjunrao87
 *
 */
public class Actions {

	public enum ElevatorAction{
		GO_UP, GO_DOWN, RESET_POSITION
	}
	
	public enum ArmAction {
		GRAB_OBJECT, LET_OBJECT_GO, RESET_POSITION
	}
	
	public enum DriveAction{
		FORWARD, BACKWARD, LEFT_TURN, RIGHT_TURN, TURN_180, RESET
	}
	
	public enum SweepAction{
		SWEEP_UP, SWEEP_DOWN, RESET_POSITION
	}
}