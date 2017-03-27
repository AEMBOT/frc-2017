package org.usfirst.frc.falcons6443.robot.commands;

/**
 * Created by chris-medlin on 2/18/17.
 */
public class MovePastAngledWall extends SimpleCommand {

    private double distanceToWall;
    private double temp;
    private double delta;
    private final double DELTA_TOLERANCE = 0.5;
    private String ultra;

    public MovePastAngledWall (String ultra) {
        super("Move Past Angled Wall");
        this.ultra = ultra;
        requires(navigation);
        requires(driveTrain);
    }

    @Override
    public void initialize () {
        driveTrain.tankDrive(1,1);
        distanceToWall = navigation.read(ultra);
    }

    @Override
    public void execute () {
        temp = distanceToWall;
        distanceToWall = navigation.read(ultra);
        delta = distanceToWall - temp;
    }

    @Override
    public boolean isFinished () {
        if (delta < DELTA_TOLERANCE) {
            driveTrain.tankDrive(0,0);
            return true;
        }
        else {
            return false;
        }
    }
}
