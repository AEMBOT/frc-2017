package org.usfirst.frc.falcons6443.robot.commands;

/**
 * @author Ivan Kenevich
 */
public class MoveToSurface extends SimpleCommand {

    public MoveToSurface() {
        super("Move to surface.");

        requires(driveTrain);
        requires(navigation);
    }

    public void initialize() {
        driveTrain.tankDrive(0.5, 0.5);
    }

    public void execute() {

    }


    public boolean isFinished() {
        if (navigation.read() < 30) {
            driveTrain.tankDrive(0, 0);
            return true;
        }
        return false;
    }
}