package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.EPIC.Mecanum_Wheels;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Slider;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Spintake;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends LinearOpMode {
    double lefty;
    double leftx;
    double righty;
    double rightx;
    Servo drone=null;




    @Override
    public void runOpMode() throws InterruptedException {
        Mecanum_Wheels wheels = new Mecanum_Wheels(hardwareMap);
        Slider slider = new Slider(hardwareMap);
        slider.parent = this;
        slider.telemetry = telemetry;

        Spintake spintake = new Spintake(hardwareMap);
        spintake.parent = this;
        spintake.telemetry = telemetry;

        wheels.initialize();
        wheels.telemetry = telemetry;
        wheels.parent = this;
        wheels.leftErrorAdjustment = 0.52;
        wheels.rightErrorAdjustment = 0.52;


        //drone
        drone=hardwareMap.get(Servo.class,"drone");

        while (opModeInInit()){
            drone.setPosition(0.67);
        }


        boolean dup2;
        boolean ddown2;
        boolean y2;
        boolean a2;
        boolean x2;




        waitForStart();
        while (opModeIsActive()){
            lefty = gamepad1.left_stick_y;
            leftx = gamepad1.left_stick_x;
            righty = gamepad1.right_stick_y;
            rightx = -gamepad1.right_stick_x;


            dup2 = gamepad2.dpad_up;
            ddown2 = gamepad2.dpad_down;
            y2 = gamepad2.y;
            a2 = gamepad2.a;
            x2 = gamepad2.x;


            wheels.move(lefty,righty,leftx,rightx);
            if(dup2){
                slider.slideup(1);

            }
            else if(ddown2){
                slider.slidedown(0.6);
            }

            if(y2){
                spintake.move(0.6);
            }

            else if(a2){
                spintake.move(-0.6);
            }

            else if(x2){
                spintake.move(0);
            } else if (gamepad2.back) {  // TODO DRONE SHOTER
                drone.setPosition(0.2);
            }
        }
    }
}
