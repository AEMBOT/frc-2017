package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This command allows the driver to control the robot with two joysticks. Both joysticks control the motors on the side
 * of the robot respective to the joystick. So the right joystick controls the motors on the right side of the robot,
 * and the left joystick controls the left motors.
 * <p>
 * This could be one of the joysticks on an XBox-like controller, or it could be something
 * like an arcade flight stick.
 *
 * @author Shivashriganesh Mahato, Patrick Higgins
 */
public class TankDriveWithJoysticks extends SimpleCommand {

	Gamepad gamepad;
	double leftInput, rightInput, fullPower;

	public TankDriveWithJoysticks() {
		super("Move With Joystick Using Tank Drive");
		requires(driveTrain);
		
		fullPower = 0.75d;
	}
	@Override
	public void initialize () {
		gamepad = Robot.oi.getGamepad();
	}
	@Override
	public void execute () {
		leftInput = gamepad.leftStickY() * driveTrain.MotorPowerModifier * fullPower;
		rightInput = gamepad.rightStickY() * driveTrain.MotorPowerModifier * fullPower;
		
		if (gamepad.rightTrigger() > 0) {
			fullPower = 1.0d;
		} else {
			fullPower = 0.75d;
		}
		
		SmartDashboard.putNumber("Left Input", leftInput);
		SmartDashboard.putNumber("Right Input", rightInput);
		
		driveTrain.updateGamepadInput(adjustedInput(leftInput), adjustedInput(rightInput));
	}

	/* There are no particular conditions in which we want the command to stop autonomously. */
	@Override
	public boolean isFinished () {
		return false;
	}
}

