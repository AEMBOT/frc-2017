package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

/**
 * Command to rotate the robot to an angle specified in a constructor parameter.
 *
 * @author Christopher Medlin, Ivan Kenevich
 */
public class RotateToAngle extends SimpleCommand implements PIDOutput {

    private double pidOutput;
    private float angle;

    private Gamepad gamepad;

    /**
     * Constructor for RotateToAngle.
	 * 
	 * @param angle the angle at which to rotate.
     */
    public RotateToAngle (float angle) {
        super("Restricted PID Drive");
        requires(navigation);
        requires(driveTrain);
        
        this.angle = angle;
    }
    
    @Override
    public void initialize () {
        gamepad = Robot.oi.getGamepad();
		navigation.reset();
        navigation.initPIDController(this);
		navigation.pidSetPoint(angle);
    }

    @Override
    public void execute () {
        driveTrain.tankDriveWithRobotDrive(pidOutput, -pidOutput);
    }

    @Override
    public boolean isFinished () {
        return false;
    }

    @Override
    public void pidWrite (double output) {
        pidOutput = output;
    }
}
