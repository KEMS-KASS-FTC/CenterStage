package org.firstinspires.ftc.teamcode.vision;



public enum Location {
    LEFT, CENTER, RIGHT, BLUE, RED, LOW, HIGH;

    public static Location checkMarker(Location Marker){
        if(Globals.ALLIANCE == Location.RED && Marker == Location.LEFT){
            return Location.RIGHT;
        } else if (Globals.ALLIANCE == Location.RED && Marker == Location.RIGHT) {
            return Location.LEFT;
        }
        return Marker;
    }
}