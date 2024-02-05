package org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Conveyor {
   DcMotorEx slider = null;
    public LinearOpMode parent;
    public Telemetry telemetry;

    public Conveyor(HardwareMap hardwareMap) {
        slider = hardwareMap.get(DcMotorEx.class,"conveyor");


    }
    public void initialize(){

    }
    public void move (double power){
        slider.setPower(power);
        parent.sleep(1000);
    }
    public void slidedown (double power){
        slider.setPower(power);
        parent.sleep(1000);
    }



}