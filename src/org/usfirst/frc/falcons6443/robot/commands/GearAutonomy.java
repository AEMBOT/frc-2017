package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Delivers a gear considering the robot starts in the center, to be used in autonomy.
 *
 * @author Shivashriganesh Mahato
 */
public class GearAutonomy extends CommandGroup {

    public GearAutonomy() {
        addSequential(new AutonomousMove(9, 12.29, true));
        addSequential(new Delay(3));
        addSequential(new ToggleGearHolder());
        addSequential(new Delay(1.5));
        addSequential(new ToggleGearHolder());
        addSequential(new AutonomousMove(3, 12.29, false));
    }

}
