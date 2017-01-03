# Strategy

1. Make basic versions of all subsystems 
2. Get teleop commands/commandgroups working
3. Get simple autonomous commands/commandgroups working
4. Gradually introduce sensory inputs ( gyro, accelerometers, etc)
5. PID integration
6. Figure out how to use GRIP pipeline in the robot and some vision processing/camera stuff too.
7. Advanced autonomous commands 
8. Run a webserver, get/set internal state
9. Redirect Robot logs to webserver to be seen on the browser
10. Connecting to SmartDashboard
11. Adding test cases to the robot 
12. Adding metrics to find how long things are taking and exposing those graphs via webserver
13. Connect Actions, Bounds, Orientation, Modules, Navigators, State,  
14. Figuring out runnables and threads in the robot

# Ask Conor

1. What is the difference between Mecanum drive, Tank Drive and Arcade Drive?
2. Why do we "invert" the motors?
3. how do we set field oriented view v/s robot oriented view?
4. How do we use Motion profiling with the CANTalon?
5. How many joysticks/what kind of controllers are we using for the robot?
6. Trajectory planning/PID 
7. What hardware do we have that we bought recently? Is it catalogued?
8. Using GRIP
9. How much data( throughput/volume ) can you publish on Network Tables?
10. Using Smart Dashboard

# Subsystem design

## Overall

1. What other methods can you have in the specific subsystem? ( either for more functionality, or for autonomous mode, or for metrics/health )

## A. Drive subsystem

1. How do you make the mecanum drive more sophisticated?

## B. Elevator subsystem

1. What other methods can you have in the Elevator speed controller that you can expose through the subsystem?
2. In the speed controllers, right now when the speed is set to 0.5, there is nothing in the code that says for how long it should run at this speed. Isnt that required?

## C. Arms subsystem

1. How can we use potentiometers/limit switches to control speed of movement of the arms instead of having a straight open/shut policy?
2. How do we know that the arm is gripping the box tight enough to lift it up? Is the shut solenoid function enough?