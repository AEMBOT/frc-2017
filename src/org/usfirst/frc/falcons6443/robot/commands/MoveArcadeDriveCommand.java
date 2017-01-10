package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 * This command allows the driver to control the robot with a single joystick. Up and down movement of the joystick
 * correspond to forward and back movement of the robot, respectively. Left and right movement of the joystick results
 * in rotation of the robot.
 * <p>
 * This could be one of the joysticks on an XBox-like controller, or it could be something
 * like an arcade flight stick.
 *
 * @author Christopher Medlin
 */
public class MoveArcadeDriveCommand extends SimpleCommand {
	
	Joystick stick;

	public MoveArcadeDriveCommand(Joystick stick) {
		super("Move With Joystick Using Arcade Drive");
		requires(driveTrain);

		this.stick = stick;
	}
	
	@Override
	public void execute () {
		//driveTrain.arcadeDrive(stick);
	}

	/* There are no particular conditions in which we want the command to stop autonomously. */
	@Override
	public boolean isFinished () {
		return false;
	}
}

