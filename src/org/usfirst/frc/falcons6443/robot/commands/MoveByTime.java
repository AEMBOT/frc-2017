package org.usfirst.frc.falcons6443.robot.commands;

/**
 * Created by higgp153 on 3/8/2017.
 */
public class MoveByTime extends SimpleCommand {

    private double stopTime;
    private double speed;

    public MoveByTime(double stopTime, double speed) {
        super("Move By Time");
        requires(driveTrain);

        this.stopTime = stopTime;
        this.speed = speed;
    }

    @Override
    public void initialize() {
        setTimeout(stopTime);
    }

    @Override
    public void execute() {
        driveTrain.tankDrive(speed,speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}