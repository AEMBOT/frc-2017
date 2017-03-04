package org.usfirst.frc.falcons6443.robot;

import org.usfirst.frc.falcons6443.robot.commands.*;
import org.usfirst.frc.falcons6443.robot.subsystems.*;

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
   
	public static final SimpleDriveTrainSystem DriveTrain = new SimpleDriveTrainSystem();
	public static final GearHolderSystem GearHolder = new GearHolderSystem();
	public static final NavigationSystem Navigation = new NavigationSystem();
	//public static final RopeClimberSystem RopeClimber = new RopeClimberSystem();
  
	public static OI oi;

	private Command autonomy;
	private Command teleop;
	private SendableChooser<Command> teleOpChooser;
	private SendableChooser<Command> autonomyChooser;
	
	/*
	 * Called when the robot first starts.
	 */
	@Override
	public void robotInit () {
		oi = new OI();
		/*
		teleOpChooser = new SendableChooser<Command>();
		teleOpChooser.addDefault("Tank Drive With Triggers", new TankDriveWithTriggers());
		teleOpChooser.addObject("Simple Tank Drive With Joystiscks", new SimpleTankDriveWithJoysticks());
		SmartDashboard.putData("TeleOp", teleOpChooser);
		
		autonomyChooser = new SendableChooser<Command>();
		autonomyChooser.addDefault("Displacement Test", new DisplacementTest());
		SmartDashboard.putData("Autonomy", autonomyChooser);
		*/
		
		assert RobotMap.isOK();
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
		/*
		autonomy = (Command) autonomyChooser.getSelected();

		if (autonomy != null) autonomy.start();
		*/
	}

	/*
	 * Called periodically when the robot is in autonomous mode.
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
		/*
		if (autonomy != null) autonomy.cancel();
		
		teleop = (Command) teleOpChooser.getSelected();
		
		if (teleop !=  null) teleop.start();
		*/
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
