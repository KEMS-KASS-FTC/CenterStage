package org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestServo {
    public Servo servo;
    public double openpos = 0;
    public double closepos = 1;
    public TestServo(HardwareMap hardwareMap) {
        servo = hardwareMap.get(Servo.class,"servo");

    }

    public void initialize(double pos){
        servo.setPosition(pos);
    }
    public void open(){
        servo.setPosition(openpos);
    }

    public void close(){
        servo.setPosition(closepos);
    }

    public void incrementPos(double pos){
        double currentpos = servo.getPosition();
        if(currentpos + pos <= 1 && currentpos+pos >= 0)
            servo.setPosition(currentpos+pos);
    }

    public double servoPos()
    {
        return servo.getPosition();
    }
}
