package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
@Disabled
@Autonomous(name="NRAutoOp", group = "NR")
public class NRAutoColorSensor extends LinearOpMode {

    DcMotor motorLeft;
    DcMotor motorRight;
    ColorSensor colorSensor;


    @Override
    public void runOpMode() throws InterruptedException {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorLeft = hardwareMap.dcMotor.get("motorRight");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        colorSensor = hardwareMap.colorSensor.get("sensor_color");
        colorSensor.enableLed(true);

        waitForStart();

        ColorSensor();

        while (colorSensor.alpha() < 20) {
            DriveForward(0.5);
            sleep(1000);
            StopDriving();
        }

//        DriveForward(0.5);
//        sleep(1000);
//        StopDriving();
//
//        TurnRight(0.5);
//        sleep(3000);
//        StopDriving();

    }

    public void DriveForward(double power){
        motorLeft.setPower(power);
        motorRight.setPower(power);
    }


    public void StopDriving(){
        DriveForward(0);
    }

    public void TurnRight(double power){
        motorLeft.setPower(-power);
        motorRight.setPower(power);

    }

    public void TurnLeft(double power){
        motorLeft.setPower(power);
        motorRight.setPower(-power);

    }


    public void ColorSensor() {

        telemetry.addData("Blue Color", colorSensor.blue());
        telemetry.addData("Red Color", colorSensor.red());
        telemetry.update();
        sleep(100);
        if (colorSensor.blue() > 10) {
            telemetry.addData("Blue greater than 10", colorSensor.blue());
            DriveForward(0.5);
        } else {
            telemetry.addData("Blue less than 10", colorSensor.blue());
        }

    }
}
