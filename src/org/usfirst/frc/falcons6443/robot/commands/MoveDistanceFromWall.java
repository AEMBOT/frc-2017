package org.usfirst.frc.falcons6443.robot.commands;

/**
 * This class utilizes ultra sonic sensors in order to move to a
 * specified point away from a wall.
 * <p>
 * This will only work properly when the robot is at a 0, 90, 180, or 270
 * degree angle, which should be possible if the angle measuring capabilities
 * of the NavX are properly utilized (which they are).
 *
 * @author Christopher Medlin
 */
public class MoveDistanceFromWall extends SimpleCommand {

    private String ultra;
    private double coord;

    /**
     * @param coord The distance from the wall.
     * @param ultra The ultrasonic sensor to be used. ("Left, Right, Back, Front").
     */
    public MoveDistanceFromWall (double coord, String ultra) {
        super("Move Distance From Wall");
        requires(driveTrain);
        requires(navigation);
        this.coord = coord;
        this.ultra = ultra;
    }

    public boolean isFinished () {
        return (navigation.read(ultra) >= coord);
    }
}
