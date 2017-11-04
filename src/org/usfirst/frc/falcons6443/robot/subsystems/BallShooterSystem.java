package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import edu.wpi.first.wpilibj.Utility;
import org.usfirst.frc.falcons6443.robot.utilities.PID;

/**
 * Uses an encoder to spin the flywheel at a constant RPM.
 */
public class BallShooterSystem extends Subsystem {

    private Victor feederFlywheel;
    private Victor shooterFlywheel;
    private Encoder flywheelEncoder;
    private PID pid;
    private double oldDistance;
    private double oldTime;
    private double desiredRPM = 0; //CHANGE THIS VALUE!!!!!
    private boolean vomit = false; //puts values to dashboard (not integrated yet)

    public BallShooterSystem () {
        shooterFlywheel = new Victor (RobotMap.ShooterFlywheel);
        feederFlywheel = new Victor (RobotMap.FeederFlywheel);
        flywheelEncoder = new Encoder (RobotMap.ShooterEncoderChannelA,
                                       RobotMap.ShooterEncoderChannelB,
                                       true, Encoder.EncodingType.k1X);
        pid = new PID(0, 0, 0, 5); //CHANGE THESE VALUES!!!
        pid.setDesiredValue(desiredRPM);
        oldTime = Utility.getFPGATime() / 1000000.0;
        if(vomit){ pid.setVomitTrue(); }
    }

    //???
    public void initDefaultCommand () {}

    public void setShooterSpeed(double rpm){
        desiredRPM = rpm;
        pid.setDesiredValue(desiredRPM);
    }

    public double getDesiredShooterSpeed(){ return desiredRPM; }

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
     * Returns true if the shooter is at speed
     */
    public boolean atSpeed () {
        return pid.isDone();
    }

    //put in a periodic function
    public void spin(){
        shooterFlywheel.set(pid.calcPID(getSpeed()));
    }

    /**
     * Starts the feeder flywheel.
     * <p>
     * Use this when shooter is atSpeed()
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
