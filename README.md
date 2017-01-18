# Crate Robot [![Build Status](https://travis-ci.org/frc4571/CrateRobot.svg?branch=master)](https://travis-ci.org/frc4571/CrateRobot) [![license](https://img.shields.io/github/license/frc4571/CrateRobot.svg)](https://github.com/frc4571/CrateRobot/blob/master/LICENSE) [![Docker Automated build](https://img.shields.io/docker/automated/frc4571/CrateRobot.svg)]() [![codecov](https://codecov.io/gh/frc4571/CrateRobot/branch/master/graph/badge.svg)](https://codecov.io/gh/frc4571/CrateRobot) [![Run Status](https://api.shippable.com/projects/5849ece7a932c20f003a439c/badge?branch=master)](https://app.shippable.com/projects/5849ece7a932c20f003a439c) [![contributors](https://img.shields.io/github/contributors/frc4571/CrateRobot.svg)](https://github.com/frc4571/CrateRobot/graphs/contributors) [![GitHub release](https://img.shields.io/github/release/frc4571/CrateRobot.svg)]() [![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/570/badge)](https://bestpractices.coreinfrastructure.org/projects/570) 


## 2.0 version of the code for the FRC 4571 robot that went to the World Championships

### About the Robot

#### Tasks

1. Drive around using mecanum wheel system [ Drive subsystem ]
2. Get a hold of a crate about 3 feet x 2 feet [ Arm subsystem ]
3. Pick up the crate and place it on an overhead shelf [ Elevator subsystem ]

#### Hardware

1. Drive subsystem
	* Mecanum wheels
	* 4 Talon SRX speed controllers

2. Arm subsystem
	* Steel arms that open and close
	* Solenoid to control the arm movement
	
3. Sweep subsystem
	* 
	* Solenoid to control the sweeping movement

4. Elevator subsystem
	* Steel lift/elevator system that are controlled by pneumatics
	* Limit switch to control extent of motion of the elevator

#### Software


### Setting up development environment

1. Clone the repository
2. Run `gradlew eclipse` for Eclipse, or `gradlew idea` for IntelliJ (Linux/Mac users should use `./gradlew` instead of `gradlew`.)
3. Edit the `build.gradle` file to reflect your desired configuration (e.g. changing the team number)

To build this module, simply run `gradlew build`.
To deploy this module to your Robot, simply run `gradlew deploy`.
If you haven't already, you can deploy [Toast](https://github.com/Open-RIO/ToastAPI) to your Robot by running `gradlew toastDeploy`.
