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

    private Joystick leftJoystick, rightJoystick;
    private boolean reversed, gearToggled, ropeClimberIdled;

    public StickTeleopMode() {
        super("Teleop Command");

        requires(driveTrain);
        requires(gearHolder);
        requires(ropeClimber);
    }

    @Override
    public void initialize() {
        leftJoystick = Robot.oi.getLeftJoystick();
        rightJoystick = Robot.oi.getRightJoystick();
        reversed = false;
        gearToggled = false;
        ropeClimberIdled = false;
    }

    @Override
    public void execute() {
        double leftThrottle = -leftJoystick.getAxis(AxisType.kY);
        double rightThrottle = -rightJoystick.getAxis(AxisType.kY);
//        double curve = joystick.getAxis(AxisType.kX);
//        double twist = joystick.getTwist();


        // the left trigger will toggle the gear holder
        if (rightJoystick.getTrigger()) {
            // safeguard for if the driver holds the trigger
            if (!gearToggled) {
                gearHolder.open();
                gearToggled = true;
            }
        } else {
            gearHolder.close();
            gearToggled = false;
        }
//
//        if (throttle == 0 && curve == 0) {
//            driveTrain.spin(twist);
//        } else {
        driveTrain.tankDrive(leftThrottle, rightThrottle);
//        }

        Smashboard.putBoolean("reversed", driveTrain.isReversed());
    }

    public boolean isFinished() {
        return false;
    }
}
