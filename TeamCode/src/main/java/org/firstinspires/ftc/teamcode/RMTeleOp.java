package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="TeleOp", group = "Main")
public class RMTeleOp extends LinearOpMode {

    MainRobot robot = new MainRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initDrive(this);
//        robot.senseColor();
//        robot.moveRobot();
        robot.print();
        sleep(2000);
        telemetry.addData("Not Blue", "***");
    }
}
