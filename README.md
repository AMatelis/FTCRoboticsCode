# FTC Robotics Code

This repository contains the full control code for our FTC robot. It handles hardware initialization, autonomous routines, tele-operated control, and subsystem logic for all major robot components. The goal of this codebase is reliability, readability, and fast iteration during the build and competition season.


## Project Overview

This codebase is structured around clear subsystems and operation modes so that each part of the robot can be developed, tested, and debugged independently. The robot is designed to support both autonomous and driver-controlled phases, with consistent behavior across practice and competition fields.

Core priorities of this project:

* Clean and modular architecture
* Easy tuning and debugging
* Hardware safety and fault tolerance
* Fast deployment during matches


## Robot Capabilities

Depending on configuration, this code supports:

* Drivetrain control with precise motor power management
* Autonomous navigation using encoders, timers, and sensors
* Game mechanism control such as intakes, slides, arms, and servos
* TeleOp driver control with adjustable sensitivity
* Sensor integration including IMU, distance sensors, and limit switches


Folder roles:

* `autonomous` contains all pre-programmed match routines
* `teleop` contains real-time driver control logic
* `subsystems` isolates each physical mechanism
* `hardware` maps motors, servos, and sensors
* `util` includes math helpers, PID controllers, and timing tools


## Setup Instructions

### Requirements

* Android Studio
* FTC SDK installed
* REV Control Hub or Expansion Hub
* Properly configured robot hardware

### Installation

1. Clone this repository into your FTC workspace
2. Open the project in Android Studio
3. Allow Gradle to sync completely
4. Verify hardware names match the configuration file
5. Build and deploy to the Control Hub or Driver Station


## Configuration

All hardware names and tuning constants are centralized to make changes quick and safe.

* Motor and servo names are defined in the hardware mapping classes
* PID values and movement constants are stored in `RobotConstants`
* Game specific values can be adjusted without touching core logic

Always double-check hardware mappings before running on a real robot.


## Autonomous Mode

Autonomous routines are written as independent OpModes. Each routine:

* Initializes required subsystems
* Executes a defined sequence of actions
* Uses encoders, timers, or sensors for control

Autonomous code is designed to be deterministic and repeatable, even under field variance.


## TeleOp Mode

TeleOp code focuses on responsiveness and driver control consistency.

Features include:

* Adjustable drive speed scaling
* Separate control of each mechanism
* Safety limits to prevent hardware damage
* Clear mapping between gamepad input and robot behavior

## Testing and Debugging

Recommended workflow:

* Test subsystems individually
* Validate autonomous paths at low speed
* Log telemetry values during operation
* Tune constants incrementally

Telemetry output is used extensively to assist with debugging and performance tuning.


## Coding Standards

This project follows consistent conventions:

* Descriptive variable and method names
* One responsibility per class
* No hard-coded values inside logic
* Comments explaining intent, not obvious syntax

The code is written to be readable by new team members and future seasons.


## Safety Notes

* Always lift the robot off the ground for first tests
* Verify motor directions before full power operation
* Keep hands clear during autonomous testing
* Stop immediately if behavior is unexpected


## Contributing

Team members are encouraged to:

* Create new branches for major changes
* Test code before merging
* Document new subsystems and features


- To get started, make sure to download the FTC Robotics rev hardware and you will need to connect to the robot via usb to connect to the code that is located on the robot and update it.  Updating this repository will not automatically update the robots code.  
Clear communication and version control discipline are expected.


## License

This project is intended for educational and competition use within the FIRST Tech Challenge framework.


## Acknowledgments

Built by the FTC team through iterative design, testing, and competition experience. Based on the official FTC SDK and community best practices.  Developed under the guidance of Gonzaga faculty: Mr. Nardella and Mr. Horan as heads of the Gonzaga Eagles Robotics Team. 

