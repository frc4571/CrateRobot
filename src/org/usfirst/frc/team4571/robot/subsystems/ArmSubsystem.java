package org.usfirst.frc.team4571.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/**
 *
 */
public class ArmSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Joystick DriverStick;
	private DoubleSolenoid s1, s2;
	
	public void Pneumatics() {
		
        DriverStick = new Joystick(1);            
        airCompressor = new Compressor(1,1);  
        airCompressor.start();                      

        s1 = new Solenoid(1);                       
        s2 = new Solenoid(2);
		
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

