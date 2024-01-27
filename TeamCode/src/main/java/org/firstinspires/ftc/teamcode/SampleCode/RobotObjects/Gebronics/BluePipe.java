package org.firstinspires.ftc.teamcode.SampleCode.RobotObjects.Gebronics;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class BluePipe extends OpenCvPipeline {
    Telemetry telemetry;
    int correctlocation = 3;
    Mat mat = new Mat();
    public enum Location{
        RIGHT,
        MIDDLE,
        LEFT
    }
    private Location location = Location.RIGHT;
    static final Rect BMiddle = new Rect(
            //new Point(200, 70),
            //new Point(250, 90));
            new Point(200, 10),
            new Point(300, 90));
    static final Rect BLeft = new Rect(
            new Point(0, 0),
            new Point(150, 80));
    static final double PERCENT_COLOR_THRESHOLD = 0.2;
    public BluePipe(Telemetry t) {telemetry = t;}

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input,mat,Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(110,100,85);  //for red h is 0 for blue it 110
        Scalar highHSV = new Scalar(128,255,255); //for red h is 10 for blue it is 128

        Core.inRange(mat,lowHSV,highHSV,mat);

        Mat middle = mat.submat(BMiddle);
        Mat left = mat.submat(BLeft);

        double middleValue = Core.sumElems(middle).val[0] / BMiddle.area() / 255;
        double leftValue = Core.sumElems(left).val[0] / BLeft.area() / 255;

        middle.release();
        left.release();

        telemetry.addData("Right raw value", (int) Core.sumElems(left).val[0]);
        telemetry.addData("Middle raw value", (int) Core.sumElems(middle).val[0]);
        telemetry.addData("Right percentage", Math.round(leftValue * 100) + "%");
        telemetry.addData("Middle percentage", Math.round(middleValue * 100) + "%");


        boolean onLeft = leftValue >PERCENT_COLOR_THRESHOLD;
        boolean onMiddle = middleValue>PERCENT_COLOR_THRESHOLD;

        if (onLeft){
            correctlocation = 2;
            location = Location.LEFT;
            telemetry.addData("LOCATION!:","MIDDLE");

        }
        else if (onMiddle){
            correctlocation = 3;
            location = Location.MIDDLE;
            telemetry.addData("LOCATION!:","RIGHT");
        }
        else{
            correctlocation = 1;
            location = Location.RIGHT;
            telemetry.addData("LOCATION!:","LEFT");
        }
        telemetry.update();
        Scalar False = new Scalar(255, 0, 0);
        Scalar True = new Scalar(0, 0, 255);


        Imgproc.cvtColor(mat,mat,Imgproc.COLOR_GRAY2RGB);
        Imgproc.rectangle(mat,BLeft , location == Location.RIGHT? True:False);
        Imgproc.rectangle(mat,BMiddle, location == Location.MIDDLE? True :False);
        return mat;
    }
    public Location getLocation(){
        return location;
    }
}