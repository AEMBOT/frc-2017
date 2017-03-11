package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

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
        requires(ropeClimber);
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
        double ropeClimberPower = gamepad.leftTrigger();
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
            if (!gearToggled) {
                // safeguard for if the driver holds the A button
                gearHolder.toggle();
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

        // set ropeClimber power.
        ropeClimber.set(ropeClimberPower);

        // set the driveTrain power.
        if (power == 0) {
            driveTrain.spin(turn/2);
        }
        else {
            driveTrain.drive(power, turn);
        }

        Smashboard.putNumber("Speed", power * 100);
        Smashboard.putNumber("RopeClimber", ropeClimberPower * 100);
        Smashboard.putBoolean("GearHolder", gearHolder.isOpen());
    }

    public boolean isFinished () {
        return false;
    }
}
