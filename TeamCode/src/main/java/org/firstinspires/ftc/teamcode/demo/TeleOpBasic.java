package org.firstinspires.ftc.teamcode.demo;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MainRobot;


@TeleOp(name="TeleOp: Basic", group = "Main")
@Disabled
public class TeleOpBasic extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        while(opModeIsActive()) {



            idle();
        }

    }
}
