package org.usfirst.frc.falcons6443.robot;

import org.usfirst.frc.falcons6443.robot.commands.MoveStraightWithTime;
import org.usfirst.frc.falcons6443.robot.commands.TeleopMode;
import org.usfirst.frc.falcons6443.robot.subsystems.RopeClimberSystem;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.falcons6443.robot.commands.MoveByTime;
import org.usfirst.frc.falcons6443.robot.subsystems.GearHolderSystem;
import org.usfirst.frc.falcons6443.robot.subsystems.NavigationSystem;
import org.usfirst.frc.falcons6443.robot.subsystems.SimpleDriveTrainSystem;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

/**
 * The Robot class is FRC team 6443's implementation of WPIlib's IterativeRobot class.
 *
 * @author Christopher Medlin
 */
public class Robot extends IterativeRobot {

	public static final SimpleDriveTrainSystem DriveTrain = new SimpleDriveTrainSystem();
	public static final GearHolderSystem GearHolder = new GearHolderSystem();
	public static final NavigationSystem Navigation = new NavigationSystem();
	public static final RopeClimberSystem RopeClimber = new RopeClimberSystem();
  
	public static OI oi;

	private MoveStraightWithTime autonomy;
	private Command teleop;;

	/*
	 * Called when the robot first starts.
	 */
	@Override
	public void robotInit () {
		oi = new OI();
		teleop = new TeleopMode();
		autonomy = new MoveStraightWithTime(1);

		CameraServer server = CameraServer.getInstance();
		server.startAutomaticCapture();

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
		if (autonomy != null) {
		    autonomy.setDuration(Smashboard.getNumber("autonomyTime", 0));
		    autonomy.start();
		}
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
		if (autonomy != null) autonomy.cancel();

		if (teleop !=  null) teleop.start();
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
