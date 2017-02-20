package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.utilities.Line2D;

/**
 * Moves the robot forward until a given line has been intersected.
 *
 * This command requires two preconditions to work properly:
 * 1. The robot must be in a 0, 90, 180, or 270 degree angle.
 * 2. The walls that the robot is measuring distance from mustn't be angled.
 *
 * It should also be noted that this command DOES NOT alter the robot's path in order
 * to intersect a line. If a robot is moving parallel to a line, this command will
 * never end.
 */
public class MoveUntilLineIntersection extends SimpleCommand {

    private Line2D line;

    private String yUltra;
    private double yVal;

    public MoveUntilLineIntersection(Line2D line, String yUltra, String xUltra) {
        super("Move Until Line Intersection.");
        requires(driveTrain);
        requires(navigation);
        this.yUltra = yUltra;
        yVal = line.calcY(navigation.readSensor(xUltra));
    }

    public void initialize () {
        driveTrain.tankDrive(1, 1);
    }

    public boolean isFinished () {
        if (navigation.readSensor(yUltra) >= yVal) {
            driveTrain.tankDrive(0, 0);
            return true;
        }
        else {
            return false;
        }
    }
}
