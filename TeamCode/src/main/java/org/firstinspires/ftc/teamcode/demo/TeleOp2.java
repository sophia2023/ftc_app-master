package org.firstinspires.ftc.teamcode.demo;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
@TeleOp(name="TeleOp2", group = "test")
public class TeleOp2 extends OpMode {

    private DcMotor motorLeft;
    private DcMotor motorRight;


    public TeleOp2() {

    }

    @Override
    public void init() {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorLeft = hardwareMap.dcMotor.get("motorRight");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if (gamepad2.a) {
            // armServo.setPosition(ARM_EXTENDED_POSITION);
        }
        if (gamepad2.b) {
            //   armServo.setPosition(ARM_RETRACTED_POSITION);
        }
    }

    @Override
    public void stop() {

    }
}