package org.usfirst.frc.falcons6443.robot.utilities;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.CameraServer;

public class Camera {
    UsbCamera cam = new UsbCamera("cam1",1);


    public void capture(){
        cam = CameraServer.getInstance().startAutomaticCapture();
    }

}
