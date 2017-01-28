package org.usfirst.frc.falcons6443.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Navigation system of the robot. Uses NavX's AHRS to read data of location and rotation of the robot relative to the
 * field.
 *
 * @author Shivashriganesh Mahato
 */
public class NavigationSystem extends Subsystem {
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

    @Override
    protected void initDefaultCommand() {
        // TODO Identify, create, and initialize default command
    }
}
