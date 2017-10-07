package org.firstinspires.ftc.teamcode.demo;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@TeleOp(name="NRTeleOp1", group = "test")
public class TeleOp1 extends LinearOpMode {

    private DcMotor motorLeft;
    private DcMotor motorRight;

    private Servo armServo;

    private static final double ARM_RETRACTED_POSITION = 0.2;
    private static final double ARM_EXTENDED_POSITION = 0.8;


    @Override
    public void runOpMode() throws InterruptedException {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorLeft = hardwareMap.dcMotor.get("motorRight");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        armServo = hardwareMap.servo.get("armServo");
        armServo.setPosition(ARM_RETRACTED_POSITION);

        waitForStart();

        while(opModeIsActive()){

            motorLeft.setPower(-gamepad1.left_stick_x);
            motorRight.setPower(-gamepad1.right_stick_y);

            if (gamepad2.a){
                armServo.setPosition(ARM_EXTENDED_POSITION);
            }
            if (gamepad2.b){
                armServo.setPosition(ARM_RETRACTED_POSITION);
            }

            idle();
        }


    }
}
