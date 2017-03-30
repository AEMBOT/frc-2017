package org.usfirst.frc.falcons6443.robot.commands;

/**
 * Created by chris-medlin on 2/20/17.
 */
public class MoveToTarget extends SimpleCommand {

    private double distanceToTarget;
    private String ultra;

    private final double SLOW_DOWN_DISTANCE = 5;
    private final double STOP_DISTANCE = 1;


    public MoveToTarget (String ultra) {
        super("Move To Target");
        this.ultra = ultra;
        requires(navigation);
        requires(driveTrain);
    }

    @Override
    public void initialize () {
        driveTrain.tankDrive(1,1);
        distanceToTarget = navigation.read(ultra);
    }

    @Override
    public void execute () {
        distanceToTarget = navigation.read(ultra);
        if (distanceToTarget <  SLOW_DOWN_DISTANCE) {
            driveTrain.tankDrive(0.4,0.4);
        }
    }

    @Override
    public boolean isFinished () {
        if (distanceToTarget < STOP_DISTANCE) {
            driveTrain.tankDrive(0,0);
            return true;
        }
        else {
            return false;
        }
    }
}