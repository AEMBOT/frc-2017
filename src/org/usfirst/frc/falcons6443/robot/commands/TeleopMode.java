package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.RobotMap;
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
    //private Ultrasonic ultrasonic;

    public TeleopMode() {
        super("Teleop Command");

        requires(driveTrain);
        requires(ballShooter);
        requires(gearHolder);
        requires(ropeClimber);
        //ultrasonic = new Ultrasonic(RobotMap.UltrasonicA, RobotMap.UltrasonicB);
    }

    @Override
    public void initialize() {
        gamepad = Robot.oi.getGamepad();

    }

    @Override
    public void execute() {
        // left bumper downshifts, right bumper upshifts.
        if (gamepad.rightTrigger() > .1) {
            ballShooter.spin(gamepad.rightTrigger());
        } else {
            ballShooter.stop();
        }

        if (gamepad.A()){
            ballShooter.stop();
        }

    }

    public boolean isFinished() {
        return false;
    }
}
