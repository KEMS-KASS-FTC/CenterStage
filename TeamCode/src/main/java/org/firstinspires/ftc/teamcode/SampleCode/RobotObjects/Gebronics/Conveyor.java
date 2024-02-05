package org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Conveyor {
    public DcMotorEx conveyor;
    //public DcMotorEx liftMotor;
    public Telemetry telemetry;
    public LinearOpMode parent;
    public boolean encoderEnabled = false;
    public double power = 0.5;

    public Conveyor(HardwareMap hardwareMap){
        conveyor = hardwareMap.get(DcMotorEx.class,"conveyor");
    }

    public void initialize(){
        if(encoderEnabled){
            conveyor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            conveyor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            conveyor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
    }

    public void move(double power) {
        conveyor.setPower(power);
    }

    public void move(int position){
        conveyor.setTargetPosition(position);
        conveyor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        conveyor.setPower(power);
    }

}
