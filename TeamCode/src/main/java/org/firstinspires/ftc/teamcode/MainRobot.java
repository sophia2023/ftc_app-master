package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MainRobot {

    private LinearOpMode rmOpMode;

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor leftBackDrive;
    private DcMotor rightBackDrive;

    private Servo   leftArm;
    private Servo   rightArm;

    private ColorSensor sensorColor;

    private double  driveAxial      = 0 ;   // Positive is forward
    private double  driveLateral    = 0 ;   // Positive is right
    private double  driveYaw        = 0 ;   // Positive is CCW


    /* Initialize standard Hardware interfaces */
    public void initDrive(LinearOpMode opMode) {

        rmOpMode = opMode;

//        // Define and Initialize Motors
//        leftDrive = rmOpMode.hardwareMap.dcMotor.get("motor_left");
//        rightDrive = rmOpMode.hardwareMap.dcMotor.get("motor_leftback");
//        leftBackDrive = rmOpMode.hardwareMap.dcMotor.get("motor_right");
//        rightBackDrive = rmOpMode.hardwareMap.dcMotor.get("motor_rightback");
//
//        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Positive input rotates counter clockwise
//        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
//        rightDrive.setDirection(DcMotor.Direction.REVERSE);
//        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
//
//
//        leftArm = rmOpMode.hardwareMap.servo.get("servo_left");
//        rightArm = rmOpMode.hardwareMap.servo.get("servo_right");
//
//        sensorColor = rmOpMode.hardwareMap.colorSensor.get("sensor_color");
//
//        moveRobot(0,0,0);

        //TODO: set Encoders
    }

    /***
     * void moveRobot(double axial, double lateral, double yaw)
     * Set speed levels to motors based on axes requests
     *
     * The code assumes the following conventions.
     * 1) Positive speed on the Axial axis means move FORWARD.
     * 2) Positive speed on the Lateral axis means move RIGHT.
     * 3) Positive speed on the Yaw axis means rotate COUNTER CLOCKWISE.
     *
     * @param axial     Speed in Fwd Direction
     * @param lateral   Speed in lateral direction (+ve to right)
     * @param yaw       Speed of Yaw rotation.  (+ve is CCW)
     */
    public void moveRobot(double axial, double lateral, double yaw) {
        axial = Range.clip(axial, -1, 1);
        lateral = Range.clip(lateral, -1, 1);
        yaw = Range.clip(yaw, -1, 1);
        moveRobot();
    }


    public void moveRobot() {
        // calculate required motor speeds to acheive axis motions
        double back = driveYaw + driveLateral;
        double left = driveYaw - driveAxial - (driveLateral * 0.5);
        double right = driveYaw + driveAxial - (driveLateral * 0.5);

        // normalize all motor speeds so no values exceeds 100%.
        double max = Math.max(Math.abs(back), Math.abs(right));
        max = Math.max(max, Math.abs(left));
        if (max > 1.0)
        {
            back /= max;
            right /= max;
            left /= max;
        }

        // Set drive motor power levels.
        leftBackDrive.setPower(back);
        leftDrive.setPower(left);
        rightDrive.setPower(right);
        rightBackDrive.setPower(right);

        // Display Telemetry
        rmOpMode.telemetry.addData("Axes  ", "A[%+5.2f], L[%+5.2f], Y[%+5.2f]", driveAxial, driveLateral, driveYaw);
        rmOpMode.telemetry.addData("Wheels", "L[%+5.2f], R[%+5.2f], B[%+5.2f]", left, right, back);
    }


    public void senseColor() {

        rmOpMode.telemetry.addData("Blue Color", sensorColor.blue());
        rmOpMode.telemetry.addData("Red Color", sensorColor.red());
        rmOpMode.telemetry.update();
        rmOpMode.sleep(100);

        if (sensorColor.blue() > 10) {
            rmOpMode.telemetry.addData("Blue", sensorColor.blue());
        } else {
            rmOpMode.telemetry.addData("Not Blue", sensorColor.blue());
        }
    }
    public void print() {
        String a = "false";
        rmOpMode.telemetry.addData("Not Blue", a);
    }

}
