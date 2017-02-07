package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

/**
 * Created by Christopher Medlin on 2/5/2017.
 */
public class RestrictedPIDDrive extends SimpleCommand implements PIDOutput {

    private double pidOutput;

    private Gamepad gamepad;

    /**
     * Constructor for RestrictedPIDDrive.
     */
    public RestrictedPIDDrive () {
        super("Restricted PID Drive");
        requires(navigation);
        requires(driveTrain);
    }

    @Override
    public void initialize () {
        gamepad = Robot.oi.getGamepad();
        navigation.initPIDController(this);
    }

    @Override
    public void execute () {
    	SmartDashboard.putNumber("Get Yaw", navigation.getYaw());
    	SmartDashboard.putNumber("PID Output", pidOutput);
    	if (gamepad.A()) {
            navigation.pidSetPoint(179.9f);
        }
        else if (gamepad.B()) {
            navigation.pidSetPoint(90.0f);
        }
        else if (gamepad.X()) {
            navigation.pidSetPoint(-90.0f);
        }
        else if (gamepad.Y()) {
            navigation.pidSetPoint(0.0f);
        }
        else if (gamepad.rightBumper()) {
        	navigation.reset();
        }
        else {}
        
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
