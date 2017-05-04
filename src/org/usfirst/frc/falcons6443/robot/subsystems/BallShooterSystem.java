package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.falcons6443.robot.RobotMap;

/**
 * Subsystem for the robot's ball shooter mechanism.
 * <p>
 * Uses an encoder to spin the flywheel at a constant RPM.
 *
 * @author Christopher Medlin
 */
public class BallShooterSystem {

    private final int DEFAULT_RPM = 1000;

    //the first flywheel which feeds the collected steam to the second flywheel
    private Victor feederFlywheel;
    //the second flywheel which shoots the steam
    private Victor shooterFlywheel;

    //the encoder, which allows the flywheel to spin at a constant RPM
    private Encoder flywheelEncoder;

    //current RPM for the second launcher flywheel
    private int rpm;

    //number of updates

    public BallShooterSystem () {
        shooterFlywheel = new Victor(RobotMap.ShooterFlywheel);
        feederFlywheel = new Victor (RobotMap.FeederFlywheel);
        rpm = DEFAULT_RPM;
    }

    public BallShooterSystem (int rpm) {
        shooterFlywheel = new Victor (RobotMap.ShooterFlywheel);
        feederFlywheel = new Victor (RobotMap.FeederFlywheel);
        this.rpm = rpm;
    }

    /**
     * Starts the shooter flywheel with an initial power of 0.5.
     */
    public void initShooter () {
        //set shooter flywheel to an initial power of 0.5
        shooterFlywheel.set(0.5);
    }

    /**
     * Starts the feeder flywheel.
     * <p>
     * It is recommended to use this after a couple iterations of the
     * shooter flywheel so that it has had time to adjust to a proper RPM.
     */
    public void initFeeder () {
        feederFlywheel.set(0.3);
    }

    /**
     * Stops both flywheels.
     */
    public void stop () {
        feederFlywheel.set(0);
        shooterFlywheel.set(0);
    }

    /**
     * Set the target RPM for the shooter flywheel.
     *
     * @param rpm the desired target RPM
     */
    public void setRPM (int rpm) {
        this.rpm = rpm;
    }
}
