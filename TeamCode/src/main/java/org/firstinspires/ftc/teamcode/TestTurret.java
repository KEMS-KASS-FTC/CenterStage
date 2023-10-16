package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.EPIC.Turret2023;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
@Disabled

@TeleOp(name = "TestTurret")
public class TestTurret extends LinearOpMode{

    public Turret2023 turret;


    @Override
    public void runOpMode() throws InterruptedException {
        turret = new Turret2023(hardwareMap);
        turret.telemetry = telemetry;
        turret.parent = this;
        turret.home();
        waitForStart();
        while (opModeIsActive()) {
            turret.turretIncrease();
            sleep(2000);
            turret.turretIncrease();
            sleep(2000);
            turret.turretIncrease();
            sleep(2000);
            turret.turretDecrease();
            sleep(2000);
            turret.turretDecrease();
            sleep(2000);
            turret.turretDecrease();
            turret.home();
            sleep(2000);
        }
    }}
