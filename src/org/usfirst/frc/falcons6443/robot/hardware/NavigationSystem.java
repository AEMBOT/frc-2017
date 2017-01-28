package org.usfirst.frc.falcons6443.robot.hardware;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

/**
 * Navigation system of the robot. Uses NavX's AHRS to read data of location and rotation of the robot relative to the
 * field.
 *
 * @author Shivashriganesh Mahato
 */
public class NavigationSystem {
    // Attitude and Heading Reference System of the NavX
    private AHRS ahrs;

    public NavigationSystem() {
        try {
            // Communicate with NavX via the MXP SPI Bus
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            // TODO Implementing means of handling and displaying exceptions for this
        }
    }

    public float[] getRawRotation() {
        return new float[] {
                ahrs.getRawGyroX(),
                ahrs.getRawGyroY(),
                ahrs.getRawGyroZ()
        };
    }

    public float[] getRawAccel() {
        return new float[] {
                ahrs.getRawAccelX(),
                ahrs.getRawAccelY(),
                ahrs.getRawAccelZ()
        };
    }

    public float[] getRawMagnetism() {
        return new float[] {
                ahrs.getRawMagX(),
                ahrs.getRawMagY(),
                ahrs.getRawMagZ()
        };
    }
}
