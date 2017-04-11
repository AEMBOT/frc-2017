package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;
import org.usfirst.frc.falcons6443.robot.hardware.JoystickPair;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 * Teleoperated mode for the robot.
 * The execute method of this class handles all possible inputs from the driver during the game.
 *
 * @author Ivan Kenevich, Christopher Medlin, Shivashriganesh Mahato
 */
public class StickTeleopMode extends SimpleCommand {

    private Joystick joystick;
    private boolean reversed, gearToggled, ropeClimberIdled;

    public StickTeleopMode() {
        super("Teleop Command");

        requires(driveTrain);
        requires(gearHolder);
        requires(ropeClimber);
    }

    @Override
    public void initialize() {
        joystick = Robot.oi.getJoystick();
        reversed = false;
        gearToggled = false;
        ropeClimberIdled = false;
    }

    @Override
    public void execute() {
        
        // the left trigger will toggle the gear holder
        if (joystick.getTrigger()) {
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
            driveTrain.drive(joystick.getAxis(AxisType.kY), joystick.getAxis(AxisType.kX));

        Smashboard.putBoolean("reversed", driveTrain.isReversed());
    }

    public boolean isFinished() {
        return false;
    }
}
