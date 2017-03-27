package org.usfirst.frc.falcons6443.robot.commands;

/**
 * Moves the robot a distance specified in the constructor.
 *
 * @author Christopher Medlin
 */
@Deprecated
public class MoveDistance extends SimpleCommand {

    double distance;
    double initUltrasonicReading;

    /**
     * @param distance the distance the robot is to move.
     */
    public MoveDistance (double distance) {
        super("Move Distance");
        this.distance = distance;
        requires(driveTrain);
        requires(navigation);
    }

    @Override
    public void initialize () {
        initUltrasonicReading = navigation.readSensor("Back");
    }

    @Override
    public boolean isFinished () {
        return (navigation.readSensor("Back") <= initUltrasonicReading + distance);
    }
}
