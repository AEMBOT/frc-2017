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
public class TwoSticksNoTankDrive extends SimpleCommand {

    private Joystick leftJoystick, rightJoystick;
    private boolean reversed, gearToggled, ropeClimberIdled;

    public TwoSticksNoTankDrive() {
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
        double throttle = -leftJoystick.getAxis(AxisType.kY);
        double curve = rightJoystick.getAxis(AxisType.kX);


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

        if (Math.abs(throttle) < 0.05) {
            driveTrain.spin(curve);
        } else {
        driveTrain.drive(throttle, curve);
        }

        Smashboard.putBoolean("reversed", driveTrain.isReversed());
    }

    public boolean isFinished() {
        return false;
    }
}

