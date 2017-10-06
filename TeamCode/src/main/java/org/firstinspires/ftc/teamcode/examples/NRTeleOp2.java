package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
@TeleOp(name="NRTeleOp2", group = "NR")
public class NRTeleOp2 extends OpMode {

    private DcMotor motorLeft;
    private DcMotor motorRight;


    public NRTeleOp2() {

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