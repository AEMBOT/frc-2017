package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 * @author Ivan Kenevich, Shivashriganesh Mahato
 */
public class AutonomousMove extends SimpleCommand implements PIDOutput {

    private double pidOutput;
    private double distance, charge, time;
    private int direction;

    /**
     * Constructor for SimpleCommand.
     */
    public AutonomousMove(double distance, double charge, boolean isReversed) {
        super("Autonomous Movement");
        requires(driveTrain);
        requires(navigation);
        this.distance = distance;
        this.charge = charge;
        time = 0;
        direction = isReversed ? -1 : 1;
    }

    @Override
    public void initialize() {
        navigation.reset();
        navigation.initPIDController(this);
        navigation.pidSetPoint(0);

        // magic numbers   WOOOOOOOH
        time = (-0.037819 * charge + 0.74216) * distance + (-0.3676 * charge + 4.26483);
        setTimeout(time);
    }

    @Override
    public void execute() {
        if (isTimedOut())
            driveTrain.tankDrive(pidOutput, -pidOutput);
        else
            driveTrain.tankDrive(direction * 0.6 + pidOutput, direction * 0.6 - pidOutput);
    }

    @Override
    protected boolean isFinished() {
        if (isTimedOut()) {
            if (navigation.onTarget()) {
                // if navx doesn't re-center the robot correctly, add a delay after the robot stopped moving
                // to let pid do its thing
                return true;
            }
        }
        return false;
    }

    @Override
    public void pidWrite(double output) {
        pidOutput = output;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getTime() {
        return time;
    }
}
