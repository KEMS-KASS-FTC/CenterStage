package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.EPIC.Mecanum_Wheels;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.EPIC.Scanner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


@TeleOp(name = "AprilTag ScannerTest")
@Disabled
public class ScannerTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        Scanner apTagScanner = new Scanner(hardwareMap);
        apTagScanner.parent = this;
        apTagScanner.telemetry = this.telemetry;
        apTagScanner.initialize();
        int pos = apTagScanner.getTagId();

        telemetry.addData("Tag Id:", pos);
        telemetry.update();
        waitForStart();

        while (opModeIsActive()){
            pos = apTagScanner.getTagId();

            telemetry.addData("Tag Id:", pos);
            telemetry.update();
            sleep(2000);
        }
        apTagScanner.releaseCamera();
    }
}