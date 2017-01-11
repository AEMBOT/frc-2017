package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.subsystems.DriveTrainSystem;

import edu.wpi.first.wpilibj.command.Command;


/**
 * Command that tells robot to move forward for 3 seconds.
 * <p>
 * Will probably not be important in the actual FRC competition, mostly temporary so that we can
 * test out the robot autonomously, and give us an introduction to command based programming.
 *
 * @author Christopher Medlin
 */
public class MoveForward extends SimpleCommand {
	
	long initTime;

	public MoveForward () {
		super("Move Forward");
		initTime = 0;
		requires(driveTrain);
	}
	
	/* Called when command first starts. */
	@Override
	public void initialize () {
		//get the robot moving forward
		driveTrain.tankDrive(1, 1);
		initTime = System.currentTimeMillis();
	}
	
	/* This method is constantly being checked. If it returns true, the command ends.
	 * Here we check if 3000 milliseconds, or 3 seconds, have passed, and return
	 * that boolean value. So, if 3 seconds have passed, the command will end.
	 */
	@Override
	public boolean isFinished () {
		return System.currentTimeMillis() - initTime >= 3000;
	}
}


