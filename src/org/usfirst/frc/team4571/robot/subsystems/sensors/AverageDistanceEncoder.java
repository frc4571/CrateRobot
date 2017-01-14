package org.usfirst.frc.team4571.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * 
 * @author arjunrao87
 *
 */
public class AverageDistanceEncoder implements PIDSource {

	private PIDSourceType pidSource;
	private Encoder leftEncoder;
	private Encoder rightEncoder;

	public AverageDistanceEncoder( Encoder leftEncoder, Encoder rightEncoder ){
		this.leftEncoder = leftEncoder;
		this.rightEncoder = rightEncoder;
	}
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		this.pidSource = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return this.pidSource;
	}

	@Override
	public double pidGet() {
		return ( ( leftEncoder.pidGet() + rightEncoder.pidGet() ) / 2.0 );
	}
}