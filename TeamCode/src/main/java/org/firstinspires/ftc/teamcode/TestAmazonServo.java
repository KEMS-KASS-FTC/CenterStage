package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.TestServo;



@TeleOp(name = "Test Amazon Servo")
@Disabled
public class TestAmazonServo extends LinearOpMode{

    public TestServo servo;
    public double incrementvalue = 0.01;

    @Override
    public void runOpMode() throws InterruptedException {
        servo = new TestServo(hardwareMap);
        servo.initialize(0);

        waitForStart();
        while(opModeIsActive()){
            boolean x = gamepad1.x;
            boolean b = gamepad1.b;
            boolean y = gamepad1.y;
            boolean a = gamepad1.a;
//            servo.open();
//            sleep(2000);
//            servo.close();
//            sleep(2000);
            if(x){
                servo.incrementPos(incrementvalue);
            }
            else if(b){
                servo.incrementPos(-incrementvalue);
            }
            else if(y){
                incrementvalue += 0.01;
            }
            else if(a){
                incrementvalue -= 0.01;
            }
            sleep(100);

            telemetry.addData("Servo Pos:%d", servo.servoPos());
            telemetry.addData("Increment Value :%d", incrementvalue);
            telemetry.update();
        }
    }
}
