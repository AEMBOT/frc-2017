package org.usfirst.frc.falcons6443.robot.hardware;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import org.usfirst.frc.falcons6443.robot.utilities.Vector3;

/**
 * Navigation system of the robot. Uses NavX's AHRS to read data of location and rotation of the robot relative to the
 * field.
 *
 * @author Shivashriganesh Mahato
 */
public class NavX {
	
	public static NavX instance;
    // Attitude and Heading Reference System of the NavX
    private AHRS ahrs;

    private NavX() {
        try {
            // Communicate with NavX via the MXP SPI Bus
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            // TODO Implementing means of handling and displaying exceptions for this
        }
    }
    public static NavX get() {
    	if (instance == null) {
    		instance = new NavX();
    	}
    	
    	return instance;
    }
    
    public Vector3 getRawRotation() {
        return new Vector3(ahrs.getRawGyroX(), ahrs.getRawGyroY(), ahrs.getRawGyroZ());
    }

    public Vector3 getRawAccel() {
        return new Vector3(ahrs.getRawAccelX(), ahrs.getRawAccelY(), ahrs.getRawAccelZ());
    }

    public Vector3 getRawMagnetism() {
        return new Vector3(ahrs.getRawMagX(), ahrs.getRawMagY(), ahrs.getRawMagZ());
    }
}
