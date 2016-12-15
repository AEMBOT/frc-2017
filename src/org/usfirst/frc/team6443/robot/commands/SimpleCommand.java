package org.usfirst.frc.team6443.robot.commands;

import org.usfirst.frc.team6443.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Serves as a class to build commands off of.
 * <p>
 * Implements all of the methods of the Command class and contains fields referring to
 * components of the Robot class. When creating a new command, inherit from this class, not
 * the Command class.
 *
 * @author Christopher Medlin
 */
public class SimpleCommand extends Command {
	private DriveTrain driveTrain = Robot.DRIVE_TRAIN;

	public void initialize(){}
	public void end(){}
	public void execute(){}
	public void interrupted(){}
	public boolean isFinished(){}
	
}
