package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.EPIC.Arm2023;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
@Disabled

@TeleOp(name = "TestArm")
public class TestArm extends LinearOpMode{

    public Arm2023 arm;

    @Override
    public void runOpMode() throws InterruptedException {
        arm = new Arm2023(hardwareMap);
        arm.telemetry = telemetry;
        arm.parent = this;
        arm.ground();
        waitForStart();
        while(opModeIsActive()){
        arm.ground();
        sleep(2000);
        arm.dropping();
        sleep(2000);

    }
}}
