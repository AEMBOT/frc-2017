package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;
import org.usfirst.frc.falcons6443.robot.hardware.JoystickPair;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

/**
 * Teleoperated mode for the robot.
 * The execute method of this class handles all possible inputs from the driver during the game.
 *
 * @author Ivan Kenevich, Christopher Medlin, Shivashriganesh Mahato
 */
public class StickTeleopMode extends SimpleCommand {

    private JoystickPair flightsticks;
    private boolean reversed, gearToggled, ropeClimberIdled;

    public StickTeleopMode() {
        super("Teleop Command");

        requires(driveTrain);
        requires(gearHolder);
        requires(ropeClimber);
    }

    @Override
    public void initialize() {
        flightsticks = Robot.oi.getFlightsticks();
        reversed = false;
        gearToggled = false;
        ropeClimberIdled = false;
    }

    @Override
    public void execute() {
        
        // the left trigger will toggle the gear holder
        if (flightsticks.leftTrigger()) {
            // safeguard for if the driver holds the trigger
            if (!gearToggled) {
                gearHolder.open();
                gearToggled = true;
            }
        } else {
            gearHolder.close();
            gearToggled = false;
        }

        // set the driveTrain power
            driveTrain.tankDrive(adjustedInput(flightsticks.leftStickY()), adjustedInput(flightsticks.rightStickY()));

        Smashboard.putBoolean("reversed", driveTrain.isReversed());
    }

    public boolean isFinished() {
        return false;
    }
}
