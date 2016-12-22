# Strategy

1. Make basic versions of all subsystems 
2. Get teleop commands working
3. Get simple autonomous commands working
4. Gradually introduce sensory inputs ( gyro, accelerometers, etc)
5. PID integration
6. Add camera + vision processing subsystems
7. Advanced autonomous commands 

# Ask Conor

1. What is the difference between Mecanum drive, Tank Drive and Arcade Drive?
2. Why do we "invert" the motors?
3. how do we set field oriented view v/s robot oriented view?


# Questions for Arjun/Inyong

## A. Drive subsystem

1. How do you make the mecanum drive more sophisticated?
2. What other methods can you have in the drive system?
3. Do you really need RambotsSubsystem ?
4. Do you really need a static instance of the Drive subsystem? Who is going to call it?


## B. Elevator subsystem

1. What other methods can you have in the Elevator speed controller that you can expose through the subsystem?
