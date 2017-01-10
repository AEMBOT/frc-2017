package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 * This command allows the driver to control the robot with two triggers (located on the back of a gamepad). Both
 * triggers control the motors on the side of the robot respective to the trigger. So the right trigger controls the
 * motors on the right side of the robot, and the left trigger controls the left motors. The power is determined by the
 *
 * <p>
 * This could be one of the joysticks on an XBox-like controller, or it could be something
 * like an arcade flight stick.
 *
 * @author Christopher Medlin
 */
public class MoveTankDriveTrigCommand extends SimpleCommand {

	Joystick gamepad;

	public MoveTankDriveTrigCommand() {
		super("Move With Triggers Using Tank Drive");
		requires(driveTrain);
		

		
	}
	@Override
	public void initialize () {
		gamepad = Robot.oi.getJoystick();
	}
	@Override
	public void execute () {
		driveTrain.updateGamepadInput(gamepad.getRawAxis(RobotMap.GamepadLeftTriggerAxisID), gamepad.getRawAxis(RobotMap.GamepadRightTriggerAxisID));
	}

	/* There are no particular conditions in which we want the command to stop autonomously. */
	@Override
	public boolean isFinished () {
		return false;
	}
}

