package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TankDrive", group="Linear OpMode")

/*
Gamepad Key:
        Gamepad1:
              Left Trigger: Slow
              Left Stick: Forward-Back, Left-Right
              Right Stick: Rotational

        Gamepad2:
                Left Trigger: Hold to rev death-wheel output motor
                Right Stick: Towards the back brings balls into ramp and the death-wheel
*/

public class TankDrive extends LinearOpMode 
{
        
    // Initialize variable that gives elapsed time
    private ElapsedTime runtime = new ElapsedTime();
    
    private Hardware robot = new Hardware();
    
    private boolean slowed = false;

    @Override
    public void runOpMode() 
    {
        robot.init(hardwareMap);
        
        // Outputs that robot is initialized
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for start and set runtime to 0
        waitForStart();
        runtime.reset();

        // Runs until opMode is disabled
        while (opModeIsActive()) 
        {
                
            double max;

//Gamepad 1 Settings
            // Left vertical moves forward and back
            double vertical = -gamepad1.left_stick_y;  // Upward on y-stick gives negative value
            
            // Left horizontal goes right and left
            double horizontal = gamepad1.right_stick_x;
            
            // Right hoirzontal rotates
            double rotation = (-gamepad1.left_bumper + gamepad1.right_bumper);


            // Calculate power per wheel based on input
            double leftFrontPower  = vertical + horizontal + rotation;
            double rightFrontPower = vertical - horizontal - rotation;
            double leftBackPower   = vertical - horizontal + rotation;
            double rightBackPower  = vertical + horizontal - rotation;
            //power for the intake servo
            double lever = 1 - 1/gamepad2.left_stick_y;

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
            
            // Allows for more precise movements if left trigger is held
            if(gamepad1.a > 0)
            {
                slowed = !slowed;
            }
            if(slowed)
            {
                leftFrontPower /= 3;
                rightFrontPower /= 3;
                leftBackPower /= 3;
                rightBackPower /= 3;
	    }
                            // Test code that powers each motor individually based on gamepad input
            
            /*
            leftFrontPower  = gamepad1.x ? 1.0 : 0.0;  // X button
            leftBackPower   = gamepad1.a ? 1.0 : 0.0;  // A button
            rightFrontPower = gamepad1.y ? 1.0 : 0.0;  // Y button
            rightBackPower  = gamepad1.b ? 1.0 : 0.0;  // B button
            */

            // Power wheels
            robot.frontLeft.setPower(leftFrontPower);
            robot.frontRight.setPower(rightFrontPower);
            robot.backLeft.setPower(leftBackPower);
            robot.backRight.setPower(rightBackPower);
            robot.ballBlaster.setPower(blasterPower);

            


                
//Gamepad 2 Settings   


               // double intakePower = gamepad2.right_stick_y; 
            
                if (gamepad2.right_trigger > 0.1) {
                    robot.ballBlaster.setPower(1.0);
                } 
                else {
                    robot.ballBlaster.setPower(0.0);
                }
            
            // Gamepad2 right vertical controls intake system
            double intakePower = gamepad2.right_stick_y;
                robot.intake.setPower(intakePower);


            // Update telemetry with appropriate data
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            //telemetry.addData("Front Left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            //telemetry.addData("Back  Left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.addData("Blaster Power", "%4.2f", blasterPower);
            //telemetry.addData("Lever Position", "%4.2f", gamepad2.left_stick_y);
            //telemetry.addData("Reverse?", "%4.2f", robot.ballBlaster.Direction);
            //telemetry.addData("Grabbed", grabbed);
            telemetry.update();
        }
    }
