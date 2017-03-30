package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

/**
 * This command allows the driver to control the robot with two triggers (located on the back of a gamepad).
 * <p>
 * The right trigger controls the right motors, the left trigger controls the left motors.
 *
 * @author Christopher Medlin, Patrick Higgins
 */
@Deprecated
public class TankDriveWithTriggers extends SimpleCommand {

	private Gamepad gamepad;

	private boolean canReverse;

	/**
	 * Constructor for TankDriveWithTriggers.
	 */

	public TankDriveWithTriggers() {
		super("Move With Triggers Using Tank Drive");

		requires(driveTrain);

		//requires(ropeClimber);
	}

	@Override
	public void initialize () {
		gamepad = Robot.oi.getGamepad();
		canReverse = true;
	}

	@Override
	public void execute () {
		double leftInput = gamepad.leftTrigger();
		double rightInput = gamepad.rightTrigger();

		if (gamepad.leftBumper()) {
			rightInput /= 2;
			leftInput /= 2;
		}

		//if the reverse key is depressed and has been released since the last reverse
		if (gamepad.leftBumper() && canReverse) {
			driveTrain.reverse();
			canReverse = false;
		}

		//if the reverse key is released, re-enable the option to reverse
		else if (!gamepad.leftBumper() && !canReverse) {
			canReverse = true;
		}

		if (gamepad.leftStickX() != 0) {
			if (gamepad.leftStickX() < 0) {
				//driveTrain.spinLeft(adjustedInput(Math.abs(gamepad.leftStickX())));
			}

			else if (gamepad.leftStickX() > 0) {
				//driveTrain.spinRight(adjustedInput(Math.abs(gamepad.leftStickX())));
			}
		}


		else {
			//driveTrain.updateGamepadInput(adjustedInput(leftInput), adjustedInput(rightInput));
		}

		if (gamepad.rightBumper()) {
			gearHolder.open();
		}

		else {
			gearHolder.close();
		}

		Smashboard.putNumber("leftTriggerVal", (int) (leftInput * 100.0));
		Smashboard.putNumber("rightTriggerVal", (int) (rightInput * 100.0));
	}

	/* There are no particular conditions in which we want the command to stop autonomously. */
	@Override
	public boolean isFinished () {
		return false;
	}
}
