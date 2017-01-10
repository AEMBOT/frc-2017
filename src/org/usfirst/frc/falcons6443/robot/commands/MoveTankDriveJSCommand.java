package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 * This command allows the driver to control the robot with two joysticks. Both joysticks control the motors on the side
 * of the robot respective to the joystick. So the right joystick controls the motors on the right side of the robot,
 * and the left joystick controls the left motors.
 * <p>
 * This could be one of the joysticks on an XBox-like controller, or it could be something
 * like an arcade flight stick.
 *
 * @author Shivashriganesh Mahato
 */
public class MoveTankDriveJSCommand extends SimpleCommand {

	Joystick leftStick;
	Joystick rightStick;

	public MoveTankDriveJSCommand(Joystick leftStick, Joystick rightStick) {
		super("Move With Joystick Using Tank Drive");
		requires(driveTrain);

		this.leftStick = leftStick;
		this.rightStick = rightStick;
	}
	
	@Override
	public void execute () {
		driveTrain.tankJSDrive(leftStick, rightStick);
		Timer.delay(0.01);
	}

	/* There are no particular conditions in which we want the command to stop autonomously. */
	@Override
	public boolean isFinished () {
		return false;
	}
}

