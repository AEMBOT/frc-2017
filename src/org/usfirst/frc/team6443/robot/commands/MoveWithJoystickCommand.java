package org.usfirst.frc.team6443.robot.commands;

import org.usfirst.frc.team6443.robot.OI;
import org.usfirst.frc.team6443.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6443.robot.commands.SimpleCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This command allows the driver to control the robot with a single joystick.
 * <p>
 * This could be one of the joysticks on an XBox-like controller, or it could be something
 * like an arcade flight stick.
 *
 * @author Christopher Medlin
 */
public class MoveWithJoystickCommand extends SimpleCommand {
	
	Joystick stick;

	public MoveWithJoystickCommand (Joystick stick) {
		super("Move With Joystick");
		requires(driveTrain);

		this.stick = stick;
	}
	
	@Override
	public void execute () {
		driveTrain.arcadeDrive(stick);
		Timer.delay(0.01);
	}

	/* There are no particular conditions in which we want the command to stop autonomously. */
	@Override
	public boolean isFinished () {
		return false;
	}
}

