package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

/**
 * The new default teleoperated mode command, replacing TankDriveWithTriggers.
 *
 * @author Christopher Medlin, Ivan Kenevich
 */
public class TeleopMode extends SimpleCommand {

    private Gamepad gamepad;
    boolean reversed, gearToggled;

    public TeleopMode () {
        super("Teleop Command");

        requires(driveTrain);
        requires(gearHolder);
    }

    @Override
    public void initialize () {
        gamepad = Robot.oi.getGamepad();
        reversed = false;
        gearToggled = false;
    }

    @Override
    public void execute () {
        double power = gamepad.rightTrigger();
        double turn = gamepad.leftStickX();

        // left bumper downshifts, right bumper upshifts.
        if (gamepad.leftBumper()) {
            driveTrain.downshift();
        }
        else if (gamepad.rightBumper()) {
            driveTrain.upshift();
        }

        // the A button will toggle the gear holder
        if (gamepad.A()) {
            // safeguard for if the driver holds the A button
            if (!gearToggled)  {
                new ToggleGearHolder().start();
                gearToggled = true;
            }
        }
        else {
            gearToggled = false;
        }

        // the Y button will toggle the drive train to reverse mode
        if (gamepad.Y()) {
            // safeguard for if the drive holds down the Y button.
            if (!reversed) {
                driveTrain.reverse();
                reversed = true;
            }
        }
        else {
            reversed = false;
        }

        // set the driveTrain power.
        if (power == 0) {
            driveTrain.spin(turn);
        }
        else {
            driveTrain.drive(power, turn);
        }
    }

    public boolean isFinished () {
        return false;
    }
}
