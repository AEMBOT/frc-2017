package org.usfirst.frc.team6443.robot;

import org.usfirst.frc.team6443.robot.commands.*;
import org.usfirst.frc.team6443.robot.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Robot class is FRC team 6443's implementation of WPIlib's IterativeRobot class. 
 *
 * @author Christopher Medlin
 */
public class Robot extends IterativeRobot {
	public static final DriveTrain DRIVE_TRAIN = new DriveTrain();
	public static OI oi;

	private Command autonomy;
	private SendableChooser chooser;
	
	/*
	 * Called when the robot first starts.
	 */
	@Override
	public void robotInit () {
		oi = new OI();
		chooser = new SendableChooser();
		chooser.addDefault("Move Forward", new MoveForwardCommand());
		SmartDashboard.putData("Auto", chooser);
	}
	
	/*
	 * Called when the robot first enters disabled mode.
	 */
	@Override
	public void disabledInit () {
		
	}
	
	/*
	 * Called periodically when the robot is in disabled mode.
	 */
	@Override
	public void disabledPeriodic () {
		Scheduler.getInstance().run();
	}
	
	/*
	 * Called when the robot first enters autonomous mode.
	 */
	@Override
	public void autonomousInit () {
		autonomousCommand =  (Command) chooser.getSelected();

		if (autonomousCommand != null) autonomousCommand.start();
	}

	/*
	 * Called periodcally when the robot is in autonomous mode.
	 */
	@Override
	public void autonomousPeriodic () {
		Scheduler.getInstance().run();
	}

	/*
	 * Called when the robot first enter teleop mode.
	 */
	@Override
	public void teleopInit () {
		if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/*
	 * Called periodically when the robot is in teleop mode.
	 */
	@Override
	public void teleopPeriodic () {
		Scheduler.getInstance().run();
	}
	
	/*
	 * Called periodically when the robot is in testing mode.
	 */
	@Override
	public void testPeriodic () {
		LiveWindow.run();
	}
}
