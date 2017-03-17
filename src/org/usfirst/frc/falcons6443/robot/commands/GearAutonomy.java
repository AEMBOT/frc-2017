package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Delivers a gear considering the robot starts in the center, to be used in autonomy.
 *
 * @author Christopher Medlin
 */
public class GearAutonomy extends CommandGroup {

    public GearAutonomy() {
        addSequential(new MoveByTime(1.5, 0.5, 0.5));
        addSequential(new MoveByTime(2, 0, 0));
        addSequential(new MoveByTime(1.5, -0.5, -0.5));
//        addSequential(new ToggleGearHolder());
//        addSequential(new MoveByTime(2, -0.5, -0.5));
//        addSequential(new ToggleGearHolder());
    }
}
