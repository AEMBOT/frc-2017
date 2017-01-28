package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

/**
 * This command allows the driver to control the robot with two triggers (located on the back of a gamepad). Both
 * triggers control the motors on the side of the robot respective to the trigger. So the right trigger controls the
 * motors on the right side of the robot, and the left trigger controls the left motors. The power is determined by the
 *
 * <p>
 * This could be one of the joysticks on an XBox-like controller, or it could be something
 * like an arcade flight stick.
 *
 * @author Christopher Medlin, Patrick Higgins
 */
public class TankDriveWithTriggers extends SimpleCommand {

	private Gamepad gamepad;
	
	private boolean canReverse;

	public TankDriveWithTriggers() {
		super("Move With Triggers Using Tank Drive");
		requires(driveTrain);
		

		
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
		if (gamepad.rightBumper() && canReverse) {
			driveTrain.reverse();
			canReverse = false;
		}
		
		//if the reverse key is released, re-enable the option to reverse
		else if (!gamepad.rightBumper() && !canReverse) {
			canReverse = true;
		}
		
		if (gamepad.leftStickX() != 0) {
			
			if (gamepad.leftStickX() < 0) {
				driveTrain.spinLeft(adjustedInput(Math.abs(gamepad.leftStickX())));
			}
			
			else if (gamepad.leftStickX() > 0) {
				driveTrain.spinRight(adjustedInput(Math.abs(gamepad.leftStickX())));
			}
		}
		
		else {
			driveTrain.updateGamepadInput(adjustedInput(leftInput), adjustedInput(rightInput));
		}
	}

	/* There are no particular conditions in which we want the command to stop autonomously. */
	@Override
	public boolean isFinished () {
		return false;
	}
}

