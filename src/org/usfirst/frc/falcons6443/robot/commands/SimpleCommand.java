package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Serves as a class to build commands off of.
 * <p>
 * Implements all of the methods of the Command class and contains fields referring to
 * components of the Robot class. When creating a new command, inherit from this class, not
 * the Command class. This excludes the isFinished() method, because there is no situation in
 * which you wouldn't implement this for a certain situation.
 *
 * @author Christopher Medlin
 */
public abstract class SimpleCommand extends Command {
	public DriveTrainSystem driveTrain = Robot.Drivetrain;
	public GearHolderSystem gearHolder = Robot.GearHolder;

	public SimpleCommand(String name) {super(name);}

	public void initialize(){}
	public void end(){}
	public void execute(){}
	public void interrupted(){}
	
	protected double adjustedInput(double input) {
		// multiple input by absolute value of input to maintain sign when squaring, important for axes
		return input * Math.abs(input);
	}
	
}
