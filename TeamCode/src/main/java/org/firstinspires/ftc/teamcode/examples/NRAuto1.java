package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Disabled
@Autonomous(name="NRAutoOp2", group = "NR")
public class NRAuto1 extends LinearOpMode {

    DcMotor motorLeft;
    DcMotor motorRight;


    @Override
    public void runOpMode() throws InterruptedException {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        DriveForward(0.5);
        sleep(1000);
        StopDriving();

        TurnRight(0.5);
        sleep(3000);
        StopDriving();

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

}
