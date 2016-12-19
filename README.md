# Crate Robot [![Build Status](https://travis-ci.org/frc4571/CrateRobot.svg?branch=master)](https://travis-ci.org/frc4571/CrateRobot) [![license](https://img.shields.io/github/license/frc4571/CrateRobot.svg)](https://github.com/frc4571/CrateRobot/blob/master/LICENSE) [![Docker Automated build](https://img.shields.io/docker/automated/frc4571/CrateRobot.svg)]() [![codecov](https://codecov.io/gh/frc4571/CrateRobot/branch/master/graph/badge.svg)](https://codecov.io/gh/frc4571/CrateRobot) [![Run Status](https://api.shippable.com/projects/5849ece7a932c20f003a439c/badge?branch=master)](https://app.shippable.com/projects/5849ece7a932c20f003a439c) [![contributors](https://img.shields.io/github/contributors/frc4571/CrateRobot.svg)](https://github.com/frc4571/CrateRobot/graphs/contributors) [![GitHub release](https://img.shields.io/github/release/frc4571/CrateRobot.svg)]() 


## 2.0 version of the code for the FRC 4571 robot that went to the World Championships

To set up this module in your development environment, follow these steps:

1. Clone the repository
2. Run `gradlew eclipse` for Eclipse, or `gradlew idea` for IntelliJ (Linux/Mac users should use `./gradlew` instead of `gradlew`.)
3. Edit the `build.gradle` file to reflect your desired configuration (e.g. changing the team number)

To build this module, simply run `gradlew build`.
To deploy this module to your Robot, simply run `gradlew deploy`.
If you haven't already, you can deploy [Toast](https://github.com/Open-RIO/ToastAPI) to your Robot by running `gradlew toastDeploy`.