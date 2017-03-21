package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

/**
 * The new default teleoperated mode command, replacing TankDriveWithTriggers.
 *
 * @author Christopher Medlin, Ivan Kenevich
 */
public class TankDriveWithTriggers extends SimpleCommand {

    private Gamepad gamepad;
    boolean reversed, gearToggled, hasShifted;

    public TankDriveWithTriggers() {
        super("Teleop Command");

        requires(driveTrain);
        requires(navigation);
        requires(gearHolder);
        requires(ropeClimber);
    }

    @Override
    public void initialize () {
        gamepad = Robot.oi.getGamepad();
        reversed = false;
        gearToggled = false;
        hasShifted = false;
    }

    @Override
    public void execute () {
        double leftPower = gamepad.leftStickY();
        double ropeClimberPower = gamepad.rightTrigger();
        double rightPower = gamepad.rightStickY();

        // left bumper downshifts, right bumper upshifts.
        if (gamepad.leftBumper()) {
            if (!hasShifted) {
                driveTrain.downshift();
                hasShifted = true;
            }
        } else if (gamepad.rightBumper()) {
            if (!hasShifted) {
                driveTrain.upshift();
                hasShifted = true;
            }
        } else {
            hasShifted = false;
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

        if (leftPower == 0) {
            driveTrain.spin(rightPower);
        }
        else if (rightPower == 0) {
            driveTrain.spin(leftPower);
        }
        else {
            driveTrain.tankDrive(leftPower, rightPower);
        }

        Smashboard.putNumber("RopeClimber", ropeClimberPower * 100);
        Smashboard.putBoolean("GearHolder", gearHolder.isOpen());
        Smashboard.putNumber("robotHeadingVal", navigation.getYaw());
    }

    public boolean isFinished () {
        return false;
    }
}
