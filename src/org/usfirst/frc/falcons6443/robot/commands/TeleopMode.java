package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

/**
 * Created by medlc645 on 3/4/2017.
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
        double turn = gamepad.leftStickX();
        double ropeClimberPower = gamepad.leftTrigger();

        if (gamepad.leftBumper()) {
            driveTrain.downshift();
        }
        else if (gamepad.rightBumper()) {
            driveTrain.upshift();
        }

        if (gamepad.A()) {
            if (!gearToggled) {
                new ToggleGearHolder().start();
                gearToggled = true;
            }
        }
        else {
            gearToggled = false;
        }

        if (gamepad.Y()) {
            driveTrain.reverse();
            driveTrain.tankDrive(0.3, 0.3);
        }
        else {
            if (driveTrain.isReversed()) {
                driveTrain.reverse();
            }
        }

        if (power == 0) {
            driveTrain.spin(turn);
        }
        else {
            driveTrain.drive(power, turn);
        }

        ropeClimber.set(-ropeClimberPower);
    }

    public boolean isFinished () {
        return false;
    }
}
