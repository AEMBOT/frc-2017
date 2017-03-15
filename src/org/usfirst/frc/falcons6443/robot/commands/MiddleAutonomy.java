package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * Created by higgp153 on 3/8/2017.
 */
public class MiddleAutonomy extends SimpleCommand {

    private double stopTime;
    private double speed;

    public MiddleAutonomy(double stopTime, double speed) {
        super("Move By Time");
        requires(driveTrain);
        requires(gearHolder);

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

    @Override
    public void end () {
        gearHolder.open();
        Timer.delay(0.25);
        driveTrain.tankDrive(-1, -1);
        Timer.delay(1);
        gearHolder.close();
    }
}
