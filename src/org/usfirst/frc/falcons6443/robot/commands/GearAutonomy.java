package org.usfirst.frc.falcons6443.robot.commands;

/**
 * Delivers a gear considering the robot starts in the center, to be used in autonomy.
 *
 * @author Christopher Medlin
 */
public class GearAutonomy extends SimpleCommand {

    public GearAutonomy() {
        super("Move By Time");
        requires(gearHolder);
        requires(driveTrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        new MoveByTime(3.5, 0.5).start();
        gearHolder.open();
        new MoveByTime(3.5, -0.5).start();
        gearHolder.close();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
