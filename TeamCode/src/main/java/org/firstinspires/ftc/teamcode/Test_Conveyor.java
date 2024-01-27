package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Conveyor;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Slider;


@TeleOp(name = "Test_Conveyor")
@Disabled
public class Test_Conveyor extends LinearOpMode {
    double lefty;
    boolean y1;
    boolean a1;



    @Override
    public void runOpMode() throws InterruptedException {
        Conveyor conveyor = new Conveyor(hardwareMap);




        conveyor.initialize();
        conveyor.telemetry = telemetry;
        conveyor.parent = this;






        waitForStart();
        while (opModeIsActive()){
            lefty = gamepad1.left_stick_y;
            a1 = gamepad1.a;
            y1 = gamepad1.y;
            if (y1)
            {
                conveyor.move(0.8);
            }
            else if (a1)
            {
                conveyor.slidedown(-0.8
                );
            }
        }
    }
}
