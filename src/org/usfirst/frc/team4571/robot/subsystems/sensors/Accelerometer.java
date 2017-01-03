package org.usfirst.frc.team4571.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.I2C;

/**
 * Wrapper class for ADXL345_I2C
 * 
 * @author arjunrao87
 *
 */
public class Accelerometer {
	
	private ADXL345_I2C accelerometer;
	
	public Accelerometer(){
		this.accelerometer = new ADXL345_I2C(I2C.Port.kOnboard, edu.wpi.first.wpilibj.interfaces.Accelerometer.Range.k4G );
	}

	public ADXL345_I2C getAccelerometer(){
		return this.accelerometer;
	}
	
	public void reset(){
		this.accelerometer.free();
	}
	
	public String values(){
		return new StringBuilder()
					.append("X:")
					.append(this.accelerometer.getX())
					.append(", Y:")
					.append(this.accelerometer.getY())
					.append(", Z:")
					.append(this.accelerometer.getZ())
					.toString();
	}
}