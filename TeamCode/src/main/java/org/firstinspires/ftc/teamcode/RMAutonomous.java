package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name ="Autonomous", group="main")
public class RMAutonomous extends LinearOpMode {

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor leftBackDrive;
    private DcMotor rightBackDrive;

    private Servo leftArm;
    private Servo rightArm;

    private ColorSensor sensorColor;

    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        waitForStart();
        removeOpponentJewel();
    }


    /* Initialize standard Hardware */
    private void initialize() {

        // Define and Initialize Motors
        leftDrive = hardwareMap.dcMotor.get("motor_left");
        rightDrive = hardwareMap.dcMotor.get("motor_leftback");
        leftBackDrive = hardwareMap.dcMotor.get("motor_right");
        rightBackDrive = hardwareMap.dcMotor.get("motor_rightback");

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Positive input rotates counter clockwise
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);


        leftArm = hardwareMap.servo.get("servo_left");
        rightArm = hardwareMap.servo.get("servo_right");

        sensorColor = hardwareMap.colorSensor.get("sensor_color");

        leftArm.setPosition(0.8);
        rightArm.setPosition(0.8);
    }

    //Select and Remove Opponent colored Jewel
    private void removeOpponentJewel() throws InterruptedException {

        telemetry.addData("Blue >", isJewelColorBlue());
        telemetry.update();

        leftArm.setPosition(1.1);

        if (isJewelColorBlue())
            moveLeft(1, 500);
        else
            moveRight(1, 500);
    }



    private boolean isJewelColorBlue() {
        if (sensorColor.blue() > 10)
            return true;
        else
            return false;
    }


    private void moveForward(double power, long time ) throws InterruptedException {
        leftDrive.setPower(power);
        leftBackDrive.setPower(power);
        rightDrive.setPower(power);
        rightBackDrive.setPower(power);

        Thread.sleep(time);
    }

    private void moveRight(double power, long time) throws InterruptedException {
        leftDrive.setPower(power);
        leftBackDrive.setPower(power);
        rightDrive.setPower(power);
        rightBackDrive.setPower(power);

        Thread.sleep(time);
    }

    private void moveLeft(double power, long time) throws InterruptedException {
        leftDrive.setPower(power);
        leftBackDrive.setPower(power);
        rightDrive.setPower(power);
        rightBackDrive.setPower(power);

        Thread.sleep(time);

    }

}
