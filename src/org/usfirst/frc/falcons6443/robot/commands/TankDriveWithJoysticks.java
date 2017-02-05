package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This command allows the driver to control the robot with two joysticks.
 * <p>
 * The Y axis of the right joystick controls tne right motors, the Y axis of the
 * left joystick controls the left motors.
 *
 * @author Shivashriganesh Mahato, Patrick Higgins
 */

@Deprecated
public class TankDriveWithJoysticks extends SimpleCommand {

	Gamepad gamepad;
	
	boolean canShift = true;

	/**
	 * Constructor for TankDriveWithJoysticks.
	 */
	public TankDriveWithJoysticks() {
		super("Move With Joystick Using Tank Drive");
		requires(driveTrain);
	}

	@Override
	public void initialize () {
		gamepad = Robot.oi.getGamepad();
	}

	@Override
	public void execute () {
		
		double leftInput = gamepad.leftStickY();
		double rightInput = gamepad.rightStickY();
		
		if (gamepad.rightBumper() && canShift) {
			driveTrain.upshift();
			canShift = false;
		}
		
		else if (gamepad.leftBumper() && canShift) {
			driveTrain.downshift();
			canShift = false;
		}
		
		else if (!gamepad.leftBumper() && !gamepad.rightBumper()) {
			canShift = true;
		}
		
		if (gamepad.leftStickButton()) {
			rightInput = leftInput;
		}
		
		else if (gamepad.rightStickButton()) {
			leftInput = rightInput;
		}
		
		if (gamepad.leftTrigger() > 0) {
			double average = (leftInput + rightInput) / 2;
			leftInput = average;
			rightInput = average;
		}
		
		driveTrain.updateGamepadInput(adjustedInput(leftInput), adjustedInput(rightInput));
	}

	@Override
	public boolean isFinished () {
		return false;
	}
}

