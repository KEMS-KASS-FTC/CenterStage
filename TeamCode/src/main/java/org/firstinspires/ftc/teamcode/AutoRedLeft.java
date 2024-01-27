package org.firstinspires.ftc.teamcode;



import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Mecanum_Wheels;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Slider;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Spintake;
import org.firstinspires.ftc.teamcode.vision.Globals;
import org.firstinspires.ftc.teamcode.vision.Location;
import org.firstinspires.ftc.teamcode.vision.PropPipeline;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous(name = "Auto Red Left")
public class AutoRedLeft extends LinearOpMode {
//    OpenCvCamera webcam;
    Mecanum_Wheels wheels = null;
    Spintake spintake = null;
    Slider slider = null;

    public static double dronePos=1;

    private PropPipeline propPipeline;
    private VisionPortal portal;
   VisionPortal visionPortal;

    public static Location Marker = Location.LEFT;

    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Mecanum_Wheels(hardwareMap);
        wheels.parent = this;
        wheels.telemetry = telemetry;
        wheels.initialize();
        spintake = new Spintake(hardwareMap);
        spintake.parent = this;
        spintake.telemetry = telemetry;

        slider = new Slider(hardwareMap);
        slider.parent = this;
        slider.telemetry = telemetry;


        double distance = 0;
        double correctionFactor = 1;


        Globals.ALLIANCE = Location.RED;
        Globals.SIDE = Location.LOW;

        ///------------------------------ PROP-PIPELINE ------------------------------///

        propPipeline = new PropPipeline();
        portal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam"))
                .setCameraResolution(new Size(1280, 720))
                .addProcessor(propPipeline)
                .setStreamFormat(VisionPortal.StreamFormat.MJPEG)
                .enableLiveView(true)
                .setAutoStopLiveView(true)
                .build();

        while (getCameraState() != VisionPortal.CameraState.STREAMING && portal.getCameraState() != VisionPortal.CameraState.STREAMING) {
            telemetry.addLine("initializing... please wait");
            telemetry.update();
        }

        while (opModeInInit()){

            telemetry.addLine("ready");
            try{
                Marker = propPipeline.getLocation();
            }catch (Exception e){
                Marker = Location.LEFT;
            }

            // JOYSTICK //
            if(gamepad1.dpad_left){
                Marker = Location.LEFT;
            }
            else if(gamepad1.dpad_up){
                Marker = Location.CENTER;
            }
            else if(gamepad1.dpad_right){
                Marker = Location.RIGHT;
            }
            telemetry.addData("marker",Marker.toString());
            telemetry.update();
        }


        waitForStart();

//
        if (Marker == Location.CENTER){ //left means top

            distance = 21;
            wheels.encoderDrive(0.45, distance, distance, distance, distance, 2);
            spintake.move(-0.6);
            sleep(2000);
            distance = -5;
            wheels.encoderDrive(0.45, distance, distance, distance, distance, 2);
            distance = -100;
            wheels.encoderDrive(0.6, -distance, distance, distance, -distance, 5);
            sleep(2000);
            slider.slidedown(1.0);
            sleep(4000);
            slider.slideup(1.0);
            sleep(6000);
        } else if (Marker == Location.RIGHT) {
            distance = 17;
            wheels.encoderDrive(0.45, distance, distance, distance, distance, 2);
            sleep(800);
            distance = 10;
            wheels.encoderDrive(0.6, -distance, distance, distance, -distance, 3);
            spintake.move(-0.6);
            sleep(2000);
            distance = -5;
            wheels.encoderDrive(0.45, distance, distance, distance, distance, 2);
            distance = -88;
            wheels.encoderDrive(0.6, -distance, distance, distance, -distance, 5);
            sleep(2000);
            slider.slidedown(1.0);
            sleep(4000);
            slider.slideup(1.0);
            sleep(6000);

        }
        else {
            distance = 19;
            wheels.encoderDrive(0.6, distance, distance, distance, distance, 2);
//            spintake.move(-0.6);
            sleep(800);
            distance = 11.5;
            wheels.encoderDrive(0.6, -distance, distance, distance, -distance, 3);
            spintake.move(-0.6);
            sleep(2000);
            distance = -5;
            wheels.encoderDrive(0.45, distance, distance, distance, distance, 2);
            distance = -100;
            wheels.encoderDrive(0.6, -distance, distance, distance, -distance, 5);
            sleep(2000);
            slider.slidedown(1.0);
            sleep(4000);
            slider.slideup(1.0);
            sleep(6000);

        }

    }
    public VisionPortal.CameraState getCameraState() {
        if (visionPortal != null) return visionPortal.getCameraState();
        return null;
    }
}

/*
///------------------------------ OPENCV ------------------------------///
private PropPipeline propPipeline;
private VisionPortal portal;
public static Location Marker = Location.RIGHT;

Globals.ALLIANCE = Location.RED;
Globals.SIDE = Location.LOW;

///------------------------------ PROP-PIPELINE ------------------------------///

propPipeline = new PropPipeline();
portal = new VisionPortal.Builder()
        .setCamera(hardwareMap.get(WebcamName.class, "Webcam"))
        .setCameraResolution(new Size(1280, 720))
        .addProcessor(propPipeline)
        .setStreamFormat(VisionPortal.StreamFormat.MJPEG)
        .enableLiveView(true)
        .setAutoStopLiveView(true)
        .build();

while (robot.getCameraState() != VisionPortal.CameraState.STREAMING && portal.getCameraState() != VisionPortal.CameraState.STREAMING) {
    telemetry.addLine("initializing... please wait");
    telemetry.update();
}

while (opModeInInit()) {
    telemetry.addLine("ready");
    try{
        Marker = propPipeline.getLocation();
    }catch (Exception e){
        Marker = Location.RIGHT;
    }

    // JOYSTICK //
    if(gamepad1.dpad_left){
        Marker = Location.LEFT;
    }
    else if(gamepad1.dpad_up){
        Marker = Location.CENTER;
    }
    else if(gamepad1.dpad_right){
        Marker = Location.RIGHT;
    }
    telemetry.addData("marker",Marker.toString());
    telemetry.update();
}

 */