package org.usfirst.frc.falcons6443.robot.commands;

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

	Joystick leftStick;
	Joystick rightStick;

	public MoveTankDriveTrigCommand(Joystick leftStick, Joystick rightStick) {
		super("Move With Triggers Using Tank Drive");
		requires(driveTrain);

		this.leftStick = leftStick;
		this.rightStick = rightStick;
	}
	
	@Override
	public void execute () {
		driveTrain.tankTrigDrive(leftStick, rightStick);
		Timer.delay(0.01);
	}

	/* There are no particular conditions in which we want the command to stop autonomously. */
	@Override
	public boolean isFinished () {
		return false;
	}
}

