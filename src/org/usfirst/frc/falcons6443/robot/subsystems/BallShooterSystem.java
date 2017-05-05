package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
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

    // PID: proportional–integral–derivative controller
    // more info at https://en.wikipedia.org/wiki/PID_controller
    public static final double KP = 0.04;  //.04
    public static final double KI = 0.001; //.001
    public static final double KD = 0.00;  //.00
    public static final double KF = 0.00;

    private final int DEFAULT_RPM = 1000;
    private int rpm;

    //the first flywheel which feeds the collected steam to the second flywheel
    private Victor feederFlywheel;
    //the second flywheel which shoots the steam
    private Victor shooterFlywheel;

    //the encoder, which allows the flywheel to spin at a constant RPM
    private Encoder flywheelEncoder;

    //PID controller to be used with the motor and the encoder
    private PIDController pid;

    public BallShooterSystem () {
        shooterFlywheel = new Victor(RobotMap.ShooterFlywheel);
        feederFlywheel = new Victor (RobotMap.FeederFlywheel);
        flywheelEncoder = new Encoder (RobotMap.ShooterEncoderChannelA,
                                       RobotMap.ShooterEncoderChannelB,
                                       true, Encoder.EncodingType.k1X);
        initPIDController(DEFAULT_RPM);
        rpm = DEFAULT_RPM;
    }

    public BallShooterSystem (int rpm) {
        shooterFlywheel = new Victor (RobotMap.ShooterFlywheel);
        feederFlywheel = new Victor (RobotMap.FeederFlywheel);
        flywheelEncoder = new Encoder (RobotMap.ShooterEncoderChannelA,
                                       RobotMap.ShooterEncoderChannelB,
                                       true, Encoder.EncodingType.k1X);
        initPIDController(rpm);
        this.rpm = rpm;
    }

    private void initPIDController (int rpm) {
        pid = new PIDController(KP, KI, KD, KF, flywheelEncoder, shooterFlywheel);
        pid.setInputRange(0, 25);
        pid.setOutputRange(0, 1);
        pid.setAbsoluteTolerance(0.5);
        pid.setContinuous(true);
        pid.setSetpoint(rpm/60);
    }

    /**
     * Starts the shooter flywheel with an initial power of 0.5.
     */
    public void initShooter () {
        //set shooter flywheel to an initial power of 0.5
        shooterFlywheel.set(0.5);
        //begin the PID feedback loop
        pid.enable();
    }

    /**
     * Starts the feeder flywheel.
     * <p>
     * It is recommended to use this after a couple iterations of the
     * shooter flywheel so that it has had time to adjust to the proper RPM.
     */
    public void initFeeder () {
        feederFlywheel.set(0.3);
    }

    /**
     * Stops both flywheels.
     */
    public void stop () {
        pid.disable();
        feederFlywheel.set(0);
        shooterFlywheel.set(0);
    }

    /**
     * Set the target RPM for the shooter flywheel.
     *
     * @param rpm the desired target RPM
     */
    public void setRPM (int rpm) {
        pid.setSetpoint(rpm/60);
        this.rpm = rpm;
    }

    /**
     * Returns the target RPM for the shooter flywheel.
     */
    public double getRPM () {
        return rpm;
    }
}
