package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name ="Autonomous", group="main")
public class RMAutonomous1 extends LinearOpMode {

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightBackDrive = null;

    private Servo leftArm;
    private Servo rightArm;

    private ColorSensor sensorColor;

    private double  driveAxial      = 0 ;   // Move forward
    private double  driveLateral    = 0 ;   // Move right
    private double  driveYaw        = 0 ;   // Positive is CCW


    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Define and Initialize Motors
        leftDrive = hardwareMap.dcMotor.get("motor_left");
        rightDrive = hardwareMap.dcMotor.get("motor_right");
        leftBackDrive = hardwareMap.dcMotor.get("motor_leftBackDrive");
        rightBackDrive = hardwareMap.dcMotor.get("motor_rightBackDrive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Positive input rotates counter clockwise
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);

        leftArm = hardwareMap.servo.get("servo_left");
        rightArm = hardwareMap.servo.get("servo_right");

        sensorColor = hardwareMap.colorSensor.get("sensor_color");
        moveRobot(0,0,0);
        moveArm(0.8, 0);

        waitForStart();

        removeOpponentJewel();

//        while (opModeIsActive()) {
//
//            parkRobotInSafeZone();
//            moveGlyph();
//
//         //   idle();
//        }


    }

    //Select and Remove Opponent colored Jewel
    private void removeOpponentJewel() {
        moveArm(0,0);
        telemetry.addData("Blue >", isJewelColorBlue());
        telemetry.update();

        if (isJewelColorBlue())
            moveRobot(1,0,0);
         else
            moveRobot(0,1,0);
    }

    public boolean isJewelColorBlue() {
        if (sensorColor.blue() > 10)
            return true;
        else
            return false;
    }

   private void parkRobotInSafeZone() {
       moveRobot(1, 1, 1);
   }


  //Score Glyphs into Crypto-boxes
  //Bonus: CryptBoxes Key Colum
    private void moveGlyph() {

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
     *  @param lateral   Speed in lateral direction (+ve to right)
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
        telemetry.addData("Axes  ", "A[%+5.2f], L[%+5.2f], Y[%+5.2f]", driveAxial, driveLateral, driveYaw);
        telemetry.addData("Wheels", "L[%+5.2f], R[%+5.2f], B[%+5.2f]", left, right, back);
      }

    public void moveArm (double leftArmPosition, double rightArmPosition) {
       leftArm.setPosition(leftArmPosition);
        rightArm.setPosition(rightArmPosition);
       }

}
