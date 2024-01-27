package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.BluePipe;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Mecanum_Wheels;
import org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics.Spintake;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous(name = "AutonBlueLeft")
public class AutonBlueLeft_old extends LinearOpMode {
    OpenCvCamera webcam;
    Mecanum_Wheels wheels = null;
    Spintake spintake = null;

    @Override
    public void runOpMode() throws InterruptedException {
        BluePipe.Location location = BluePipe.Location.LEFT;
        wheels = new Mecanum_Wheels(hardwareMap);
        wheels.parent = this;
        wheels.telemetry = telemetry;
        wheels.initialize();
        spintake = new Spintake(hardwareMap);
        spintake.parent = this;
        spintake.telemetry = telemetry;
        double distance = 0;
        double correctionFactor = 1;
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        BluePipe detector = new BluePipe(telemetry);
        webcam.setPipeline(detector);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {
                telemetry.addData("Error:", "Camera cant stream");
            }
        });

        location = detector.getLocation();
        sleep(1000);
        waitForStart();
        //location = detector.getLocation();
        location = BluePipe.Location.LEFT;
        if (location == BluePipe.Location.LEFT){ //left means top

            distance = 21;
            wheels.encoderDrive(0.6, distance, distance, distance, distance, 2);
            spintake.move(-0.6);
            sleep(2000);
            distance = 28;
            wheels.encoderDrive(0.6, -distance, distance, distance, -distance, 3);
        }

    }
}