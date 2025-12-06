package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class Hardware 
{
    // Declare motors
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;
    
    // Declare Elevator
    public DcMotor elevator;
    public DcMotor reverseElevator;
    
    // Declare servos
    public Servo grabber;

    HardwareMap hardwareMap;
    
    public void init(HardwareMap hardwareMap)    
    {
        // Initialize the hardware variables
        
        //Motors 
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backRight = hardwareMap.get(DcMotor.class, "back_right");
        
        // Elevator Motors
        elevator = hardwareMap.get(DcMotor.class, "elevator");
        reverseElevator = hardwareMap.get(DcMotor.class, "reverse_elevator");
        intake = hardwareMap.get(DcMotor.class, "intake"); 
        
        // Servos
        grabber = hardwareMap.get(Servo.class, "grabber");

        // Initialize direction of motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        
        elevator.setDirection(DcMotor.Direction.FORWARD);
        reverseElevator.setDirection(DcMotor.Direction.FORWARD); 
        
        // Initialize Servos
        grabber.setPosition(0);
    }
}

