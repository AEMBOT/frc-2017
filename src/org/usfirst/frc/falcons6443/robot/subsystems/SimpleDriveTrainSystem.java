package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.TankDriveWithTriggers;
import org.usfirst.frc.falcons6443.robot.hardware.SpeedControllerGroup;

/**
 * Subsystem for the robot's drive train.
 * <p>
 * Contains 2 VictorSPGroups for the left and right motors and several boolean values pertaining
 * to the drive train.
 *
 * @author Christopher Medlin, Patrick Higgins, Shivashriganesh Mahato
 */
public class SimpleDriveTrainSystem extends Subsystem {

	public static final double KP = 0.04;  //.04
	public static final double KI = 0.001; //.001
	public static final double KD = 0.00;  //.00
	public static final double KF = 0.00;

	private static final double GEAR_ONE =  0.3;
	private static final double GEAR_TWO = 0.6;
	private static final double GEAR_THREE = 1;

	private static final double MAXIMUM_CURVE = 0.36787944;

	private SpeedControllerGroup leftMotors;
	private SpeedControllerGroup rightMotors;

	private boolean isSpinning;
	private boolean reversed;

	private int speedLevel;

	private RobotDrive drive;

	/**
	 * Constructor for DriveTrainSystem.
	 */
	public SimpleDriveTrainSystem() {
		//invert motors here
		  
	    leftMotors = new SpeedControllerGroup(new VictorSP(RobotMap.FrontLeftVictor),
											  new VictorSP(RobotMap.BackLeftVictor));
		
		rightMotors = new SpeedControllerGroup(new VictorSP(RobotMap.FrontRightVictor),
				 							   new VictorSP(RobotMap.BackRightVictor));
		
		isSpinning = false;
		reversed = false;

		drive = new RobotDrive(leftMotors, rightMotors);

		speedLevel = 1; //start in lowest speed mode
	}
	
	@Override
	public void initDefaultCommand () {
		setDefaultCommand(new TankDriveWithTriggers());
	}

	/**
	 * Allows for custom setting of motor power level.
	 *
	 * @param left the power for the left motors.
	 * @param right the power for the right motors.
	 */
	public void tankDrive(double left, double right) {
		if (reversed) {
			drive.tankDrive(-left, -right);
		}
		else {
			drive.tankDrive(left, right);
		}
	}
	
	/**
	 * Spins the robot counterclockwise.
	 *
	 * @param speed the speed at which the robot spins.
	 */
	public void spin(double speed) {
		drive.tankDrive(speed, -speed);
	}
	
	/**
	 * Toggles the motors to go in reverse.
	 */
	public void reverse() {
		if (!reversed) {
			reversed = true;
		}
		else  {
			reversed = false;
		}
	}
	

	/**
	 * Increases the maximum speed level.
	 */
	public void upshift() {
		if (speedLevel != 3) {
			speedLevel++;
		}
		updateMaxOutput();
	}
	
	/**
	 * Decreases the max speed level.
	 */
	public void downshift() {
		if (speedLevel != 1) {
			speedLevel--;
		}
		updateMaxOutput();
	}
	
	/**
	 * @return whether the robot is reversed
	 */
	public boolean isReversed() {
		return reversed;
	}
	
	/**
	 * Gets the current maximum speed level.
	 *
	 * @return the current speed level of the robot.
	 */
	public int getSpeedLevel() {
		return speedLevel;
	}

	/**
	 * Sets all motors to a desired speed.
	 *
	 * @param speed the desired speed.
	 */
	public void drive (double speed, double curve) {
		drive.drive(speed, curve * MAXIMUM_CURVE);
	}

	private void updateMaxOutput () {
		if (speedLevel == 1) {
			drive.setMaxOutput(GEAR_ONE);
		}
		else if (speedLevel == 2) {
			drive.setMaxOutput(GEAR_TWO);
		}
		else {
			drive.setMaxOutput(GEAR_THREE);
		}
	}
}
