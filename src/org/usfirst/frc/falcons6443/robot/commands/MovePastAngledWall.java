package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * Moves the robot passed one of four angled walls at the corners of
 * the field.
 *
 * @author Christopher Medlin
 */
public class MovePastAngledWall extends SimpleCommand {

    private double distanceToWall;
    private double temp;
    private double delta;
    private final double DELTA_TOLERANCE = 0.5;
    private String ultra;

    /**
     * @param ultra Ultrasonic sensor on the side of the robot facing
     *              the angled wall.
     */
    public MovePastAngledWall (String ultra) {
        super("Move Past Angled Wall");
        this.ultra = ultra;
        requires(navigation);
        requires(driveTrain);
    }

    @Override
    public void initialize () {
        driveTrain.tankDrive(1,1);
        distanceToWall = navigation.readSensor(ultra);
    }

    @Override
    public void execute () {
        temp = distanceToWall;
        distanceToWall = navigation.readSensor(ultra);
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
