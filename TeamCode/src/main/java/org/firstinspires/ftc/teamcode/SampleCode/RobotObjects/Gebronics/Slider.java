package org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Slider {
   DcMotorEx slider = null;
    public LinearOpMode parent;
    public Telemetry telemetry;

    public Slider(HardwareMap hardwareMap) {
        slider = hardwareMap.get(DcMotorEx.class,"slider");
        slider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
    public void initialize(){

    }
    public void slideup (double power){
        slider.setPower(power);
        parent.sleep(100);
        slider.setPower(0);
    }
    public void slidedown (double power){
        slider.setPower(-power);
        parent.sleep(100);
        slider.setPower(0);
    }


}
