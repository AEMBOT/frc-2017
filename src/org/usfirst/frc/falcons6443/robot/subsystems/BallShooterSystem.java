package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import edu.wpi.first.wpilibj.Utility;
import org.usfirst.frc.falcons6443.robot.subsystems.PID;

/**
 * Uses an encoder to spin the flywheel at a constant RPM.
 */
public class BallShooterSystem extends Subsystem {

    //the first flywheel which feeds the collected steam to the second flywheel
    private Victor feederFlywheel;
    //the second flywheel which shoots the steam
    private Victor shooterFlywheel;
    //the encoder, which allows the flywheel to spin at a constant RPM
    private Encoder flywheelEncoder;
    private PID pid;
    private double currentRPM;
    private double oldDistance;
    private double oldTime;

    public BallShooterSystem (int rpm) {
        shooterFlywheel = new Victor (RobotMap.ShooterFlywheel);
        feederFlywheel = new Victor (RobotMap.FeederFlywheel);
        flywheelEncoder = new Encoder (RobotMap.ShooterEncoderChannelA,
                                       RobotMap.ShooterEncoderChannelB,
                                       true, Encoder.EncodingType.k1X);
        pid = new PID(.1, .5, 0, 5);
       // PID.initPIDController(rpm, flywheelEncoder, shooterFlywheel);
        pid.setDesiredValue(rpm);
        oldTime = Utility.getFPGATime() / 1000000.0;
    }

    public void initDefaultCommand () {}

    public double getSpeed(){
        return (updateSpeed());
    }

    public double updateSpeed(){
        double distance = flywheelEncoder.getDistance() / 1024; //divide by ticks per rotation
        double time = Utility.getFPGATime() / 1000000.0; //milliseconds to seconds
        double speed = ((distance - oldDistance) / (time - oldTime)) * 60; //rotations per second
        double rpm = speed * 60; //rotations per minute
        oldDistance = distance;
        oldTime = time;
        return rpm;
    }

    /**
     * Starts the shooter flywheel with an initial power of 0.5
     */
    public void initShooter () {
        //set shooter flywheel to an initial power of 0.5
        //shooterFlywheel.set(0.5);
        //begin the PID feedback loop
        //pid.calcPID(getSpeed());
    }

    //put in a periodic function
    public void spin(){
        shooterFlywheel.set(pid.calcPID(getSpeed()));
    }

    /**
     * Starts the feeder flywheel.
     * <p>
     * It is recommended to use this after a couple iterations of the
     * shooter flywheel so that it has had time to adjust to the proper RPM.
     */
    public void feeder () {
        feederFlywheel.set(0.3);
    }

    /**
     * Stops both flywheels.
     */
    public void stop () {
        feederFlywheel.set(0);
        shooterFlywheel.set(0);
    }
}
