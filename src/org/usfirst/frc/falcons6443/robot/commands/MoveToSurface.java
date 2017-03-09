package org.usfirst.frc.falcons6443.robot.commands;

/**
 * Created by chris-medlin on 3/8/17.
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

    public void end () {
        driveTrain.tankDrive(0, 0);
    }

    public boolean isFinished () {
        return navigation.isMoving();
    }
}
