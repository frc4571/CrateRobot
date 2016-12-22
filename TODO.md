# Strategy

~~ 1. Make basic versions of all subsystems ~~ 
2. Get teleop commands working
3. Get simple autonomous commands working
4. Gradually introduce sensory inputs ( gyro, accelerometers, etc)
5. PID integration
6. Add camera + vision processing subsystems
7. Advanced autonomous commands 
8. Run a webserver, get/set internal state

# Ask Conor

1. What is the difference between Mecanum drive, Tank Drive and Arcade Drive?
2. Why do we "invert" the motors?
3. how do we set field oriented view v/s robot oriented view?
4. How do we use Motion profiling with the CANTalon?

# TODO

## Overall

1. Do you really need IRambotsSubsystem ?
2. Do you really need a static instance of the Drive subsystem? Who is going to call it?
3. Adding metrics and robot/subsystem health/state information
4. Connecting to SmartDashboard
5. Adding test cases to the robot 
6. What other methods can you have in the specific subsystem? ( either for more functionality, or for autonomous mode, or for metrics/health )

## A. Drive subsystem

1. How do you make the mecanum drive more sophisticated?

## B. Elevator subsystem

1. What other methods can you have in the Elevator speed controller that you can expose through the subsystem?

## C. Arms subsystem

1. How can we use potentiometers/limit switches to control speed of movement of the arms instead of having a straight open/shut policy?
2. How do we know that the arm is gripping the box tight enough to lift it up? Is the shut solenoid function enough?