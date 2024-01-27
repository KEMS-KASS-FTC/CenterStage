package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.EPIC.Mecanum_Wheels;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Slider;


@TeleOp(name = "Test_Slider")
@Disabled
public class Test_Slider extends LinearOpMode {
    double lefty;
    boolean y1;
    boolean a1;



    @Override
    public void runOpMode() throws InterruptedException {
        Slider slider = new Slider(hardwareMap);




        slider.initialize();
        slider.telemetry = telemetry;
        slider.parent = this;






        waitForStart();
        while (opModeIsActive()){
            lefty = gamepad1.left_stick_y;
            a1 = gamepad1.a;
            y1 = gamepad1.y;
            if (y1)
            {
                slider.slideup(0.4);
            }
            else if (a1)
            {
                slider.slidedown(-0.4);
            }
        }
    }
}
