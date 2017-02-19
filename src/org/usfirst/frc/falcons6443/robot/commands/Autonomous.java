package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.falcons6443.robot.utilities.Line2D;

/**
 * Contains 3 nested command group classes, each corresponding to
 * a possible starting position.
 *
 * @author Christopher Medlin
 */
public class Autonomous {

    /**
     * Bottom right/top left.
     */
    public static class PositionOne extends CommandGroup {
        public PositionOne () {
            addSequential(new MovePastAngledWall("Right"));
            addSequential(new MoveUntilLineIntersection(new Line2D(-0.577, 242.66), ));
            addSequential(new RotateToAngle(60f));
        }

    }
}
