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

        // holding the B button will start the ball shooter
        if (gamepad.B()) {
            ballShooter.spin();
            //the right trigger will start feeder wheel when the PID is done
            if (gamepad.rightTrigger() > .8) {
                ballShooter.feeder();
            }

            //override with start button
            if(gamepad.back()){
                ballShooter.feeder();
            }
        } else {
            ballShooter.stop();
        }

    }

    public boolean isFinished() {
        return false;
    }
}
