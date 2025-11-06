package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="My Autonomous", group="Linear OpMode")
public class MyAutonomous extends LinearOpMode {

    Hardware robot = new Hardware();

    @Override
    public void runOpMode() {
      
        robot.init(hardwareMap);

    
        telemetry.addData("Status", "Initialized");
        telemetry.update(); 
      
        waitForStart();

        robot.frontLeft.setPower(0.5);
        robot.frontRight.setPower(0.5);
        robot.backLeft.setPower(0.5);
        robot.backRight.setPower(0.5);
        sleep(1000); // drive forward for 1 second

        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);

        robot.elevator.setPower(1.0);
        robot.reverseElevator.setPower(1.0);
        sleep(500); // run elevator for 0.5 seconds
        robot.elevator.setPower(0);
        robot.reverseElevator.setPower(0);

        robot.grabber.setPosition(1); // close grabber
        sleep(500); // wait for servo to move

        robot.frontLeft.setPower(-0.5);
        robot.frontRight.setPower(-0.5);
        robot.backLeft.setPower(-0.5);
        robot.backRight.setPower(-0.5);
        sleep(500);

        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
      
        telemetry.addData("Status", "Autonomous Complete");
        telemetry.update();
    }
}
