package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Delivers a gear considering the robot starts in the center, to be used in autonomy.
 *
 * @author Shivashriganesh Mahato
 */
public class GearAutonomy extends CommandGroup {

    private final double CHARGE = 12.60;

    public GearAutonomy() {
        addSequential(new AutonomousMove(5.4,CHARGE,false));
        addSequential(new AutonomousRecenter(3,false));
        addSequential(new ToggleGearHolder());
        addSequential(new Delay(0.5));
        addSequential(new ToggleGearHolder());
        addSequential(new Delay(0.5));
        addSequential(new ToggleGearHolder());
        addSequential(new Delay(0.5));
        addSequential(new ToggleGearHolder());
        addSequential(new AutonomousMove(5.4,CHARGE,true));
        addSequential(new RotateToAngle(-45,2));
        addSequential(new AutonomousMove(5.4,CHARGE,false));
    }

}
