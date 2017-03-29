package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import org.usfirst.frc.falcons6443.robot.subsystems.SimpleDriveTrainSystem;

/**
 * @author Ivan Kenevich
 */
public class MoveToSurface extends SimpleCommand {

    public MoveToSurface () {
        super("Move to surface.");

        requires(driveTrain);
        requires(navigation);
    }

    public void initialize () {
        driveTrain.tankDrive(0.5,0.5);
    }

    public void execute () {

    }


    public boolean isFinished () {
        if (driveTrain.read() < 30) {
            driveTrain.tankDrive(0,0);
            return true;
        }
        return false;
    }
}