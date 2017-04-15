package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 * Command to rotate the robot to an angle specified in a constructor parameter.
 *
 * @author Christopher Medlin, Ivan Kenevich
 */
public class RotateToAngle extends SimpleCommand implements PIDOutput {

    private double pidOutput;
    private double angle;
    private double time;

    /**
     * Constructor for RotateToAngle.
     *
     * @param angle the angle at which to rotate.
     */
    public RotateToAngle(double angle, double seconds) {
        super("Restricted PID Drive");
        requires(navigation);
        requires(driveTrain);
        this.angle = angle;
        time = seconds;
    }

    @Override
    public void initialize() {
        initPIDController();
        setTimeout(time);
    }

    public void initPIDController() {
        navigation.initPIDController(this);
        navigation.pid.setPID(0.08, 0, 0);
        navigation.pid.setOutputRange(-0.6, 0.6);
        navigation.pid.setSetpoint(angle);
        navigation.enablePID();
    }

    @Override
    public void execute() {
        driveTrain.tankDrive(pidOutput, -pidOutput);
    }

    @Override
    public boolean isFinished() {
        if (navigation.pid.onTarget() && isTimedOut()) {
            driveTrain.tankDrive(0, 0);
            navigation.freePID();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void pidWrite(double output) {
        pidOutput = output;
    }
}
