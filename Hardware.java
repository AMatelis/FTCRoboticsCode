package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
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
    public DcMotor elevator;
    
    // Declare ballBlaster
    public DcMotor ballBlaster;
    public DcMotor intake;
    
    //camera
    public WebcamName camera;

    private HardwareMap hardwareMap;
    
    public void init(HardwareMap hardwareMap)    
    {
        // Initialize the hardware variables
        this.hardwareMap = hardwareMap; 
        
        
        //Motors 
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backRight = hardwareMap.get(DcMotor.class, "back_right");
        
        // Activity motors
        ballBlaster = hardwareMap.get(DcMotor.class, "ballShooter");
        intake = hardwareMap.get(DcMotor.class, "intake");

        // Initialize direction of motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        
        ballBlaster.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.REVERSE);
        
        //camera
        camera = hardwareMap.get(WebcamName.class, "Webcam 1");
        

    }
}
