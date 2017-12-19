package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

/**
 * Teleoperated mode for the robot.
 * The execute method of this class handles all possible inputs from the driver during the game.
 *
 * @author Ivan Kenevich, Christopher Medlin, Shivashriganesh Mahato
 */
public class TeleopMode extends SimpleCommand {

    private Gamepad gamepad;
    private boolean reversed, gearToggled, ropeClimberIdled, ballShooterInitiated;
    private int bPressCount;

    public TeleopMode() {
        super("Teleop Command");

        requires(driveTrain);
        //requires(gearHolder);
        //requires(ropeClimber);
        requires(ballShooter);
    }

    @Override
    public void initialize() {
        gamepad = Robot.oi.getGamepad();
        ballShooterInitiated = false;
    }

    @Override
    public void execute() {
        double throttle = gamepad.rightTrigger();
        double turn = gamepad.leftStickX();
        double ropeClimberThrottle = gamepad.leftTrigger();

        // left bumper downshifts, right bumper upshifts.
        if (gamepad.leftBumper()) {
            driveTrain.downshift();
        } else if (gamepad.rightBumper()) {
            driveTrain.upshift();
        }

        // set the driveTrain power.
        if (throttle == 0) {
            driveTrain.spin(turn);
        } else {
            driveTrain.drive(throttle, turn);
        }

        Smashboard.putBoolean("reversed", driveTrain.isReversed());
    }

    public boolean isFinished() {
        return false;
    }
}
