package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 * @author Ivan Kenevich
 */
public class MoveToSurface extends SimpleCommand implements PIDOutput {

    private double distance;
    private double pidOutput;

    public MoveToSurface(double inches) {
        super("Move to surface.");

        requires(driveTrain);
        requires(navigation);

        distance = inches;
    }

    public void initialize() {
        navigation.initPIDController(this);
        navigation.pid.setSetpoint(0);
        navigation.pid.setOutputRange(0.05, 0.05);
        navigation.enablePID();
    }

    public void execute() {
        driveTrain.tankDrive(0.6 + pidOutput, 0.6 - pidOutput);
    }

    public boolean isFinished() {
        if (navigation.readInches() < distance) {
            driveTrain.tankDrive(0, 0);
            return true;
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
}