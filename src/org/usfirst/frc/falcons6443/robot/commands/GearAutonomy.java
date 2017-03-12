package org.usfirst.frc.falcons6443.robot.commands;

/**
 * Delivers a gear considering the robot starts in the center, to be used in autonomy.
 *
 * @author Christopher Medlin
 */
public class GearAutonomy extends SimpleCommand {

    public GearAutonomy() {
        super("Move By Time");
        requires(driveTrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // TESTING
        // Go forward for 2 seconds, turn, and go forward again for 2 seconds
        new MoveByTime(2, 0.5, 0.5).start();
        new RotateToAngle(45).start();
        new MoveByTime(2, 0.5, 0.5).start();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
