package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name ="Autonomous", group="main")
public class RMAutonomous extends LinearOpMode {

    MainRobot robot = new MainRobot();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.initDrive(this);

        waitForStart();
        robot.senseColor();
        robot.moveRobot();

    }
}
