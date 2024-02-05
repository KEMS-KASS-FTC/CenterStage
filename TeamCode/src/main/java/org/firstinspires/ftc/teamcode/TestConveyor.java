package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.EPIC.Arm2023;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Conveyor;

//@Disabled

@TeleOp(name = "Test Conveyor")
public class TestConveyor extends LinearOpMode{

    public Conveyor conveyor;

    @Override
    public void runOpMode() throws InterruptedException {
        conveyor = new Conveyor(hardwareMap);
        conveyor.telemetry = telemetry;
        conveyor.parent = this;
        conveyor.power = 0.4;
        waitForStart();
        while(opModeIsActive()){
        conveyor.move(-0.4);
        sleep(2000);
        //conveyor.move(0.4);

    }
}}
