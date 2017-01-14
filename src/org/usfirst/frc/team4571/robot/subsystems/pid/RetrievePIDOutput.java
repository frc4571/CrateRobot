package org.usfirst.frc.team4571.robot.subsystems.pid;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 * @TODO : Need to see if this class does what it seems like it does
 * 
 * @author arjunrao87
 *
 */
public class RetrievePIDOutput implements PIDOutput {

	private double output;
	
	@Override
	public void pidWrite(double output) {		
		this.output = output;
	}

	public double getOutput(){
		return this.output;
	}
}