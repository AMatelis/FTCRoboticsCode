package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="SimpleAuto", group="Linear OpMode")

public class SimpleAuto extends LinearOpMode 
{
    Hardware robot = new Hardware();
     
    boolean grabbed = false;

    @Override
    public void runOpMode() 
    {
        robot.init(hardwareMap);
        
        // Outputs that robot is initialized
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for start and set runtime to 0
        waitForStart();
        
        simpleAuto();
        
        // auto();
        // sleep(2000);
        // reverseAuto();
    }
    
    public void simpleAuto()
    {
        motors(-1, 0, -0.05);
        sleep(400);
    }
    
   
    
    public void motors(double vertical, double horizontal, double rotation)
    {
        double max; 
        
        // Calculate power per wheel based on input
        double leftFrontPower  = vertical + horizontal + rotation;
        double rightFrontPower = vertical - horizontal - rotation;
        double leftBackPower   = vertical - horizontal + rotation;
        double rightBackPower  = vertical + horizontal - rotation;

        // Normalize so maximum power a wheel can have is 1
        max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));
        
        // Apply normalization to wheels if needed
        if (max > 1.0) 
        {
            leftFrontPower /= max;
            rightFrontPower /= max;
            leftBackPower /= max;
            rightBackPower /= max;
        }
        
        // Power wheels
        robot.frontLeft.setPower(leftFrontPower);
        robot.frontRight.setPower(rightFrontPower);
        robot.backLeft.setPower(leftBackPower);
        robot.backRight.setPower(rightBackPower);

        // Update telemetry with appropriate data
        telemetry.addData("Front Left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
        telemetry.addData("Back  Left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
        telemetry.update();
    }
    
    }
}
