package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.hardware.SpeedControllerGroup;
import org.usfirst.frc.falcons6443.robot.commands.*;

/**
 * Subsystem for the robot's drive train.
 * <p>
 * Contains 2 VictorSPGroups for the left and right motors and several boolean values pertaining
 * to the drive train.
 *
 * @author Christopher Medlin, Patrick Higgins, Shivashriganesh Mahato
 */
public class DriveTrainSystem extends Subsystem {

	public static final double KP = 0.04;  //.04
	public static final double KI = 0.001; //.001
	public static final double KD = 0.00;  //.00   
	public static final double KF = 0.00;

	public static final double MotorPowerModifier = .75; //multiplier for max motor power
	
	private SpeedControllerGroup leftMotors;
	private SpeedControllerGroup rightMotors;
	
	private boolean isSpinning;
	private boolean reversed;
	
	private int speedLevel;

	private RobotDrive drive;

	/**
	 * Constructor for DriveTrainSystem.
	 */
	public DriveTrainSystem() {
		VictorSP frontLeft = new VictorSP(RobotMap.FrontLeftVictor);
		VictorSP backLeft = new VictorSP(RobotMap.BackLeftVictor);
		VictorSP frontRight = new VictorSP(RobotMap.FrontRightVictor);
		VictorSP backRight = new VictorSP(RobotMap.BackRightVictor);
		
		//invert motors here
		  
		leftMotors = new SpeedControllerGroup(frontLeft, backLeft);
		
		rightMotors = new SpeedControllerGroup(frontRight, backRight);
		
		isSpinning = false;
		reversed = false;

		speedLevel = 1; //start in highest speed mode
	}
	
	@Override
	public void initDefaultCommand () {
		setDefaultCommand(new TankDriveWithTriggers());
	}

	/**
	 * Passes desired tank drive inputs to instance of RobotDrive
	 * 
	 * @param left left axis value.
	 * @param right right axis value.
	 */
	public void updateGamepadInput(double left, double right) {
		tankDrive(left, right);
		
		SmartDashboard.putNumber("Speed Level", (leftMotors.get() + rightMotors.get()) / 2);
		SmartDashboard.putNumber("Left Input", left * MotorPowerModifier / speedLevel);
		SmartDashboard.putNumber("Right Input", right * MotorPowerModifier / speedLevel);
		
	}

	/**
	 * Allows for custom setting of motor power level.
	 *
	 * @param left the power for the left motors.
	 * @param right the power for the right motors.
	 */
	public void tankDrive(double left, double right) {
		if (isSpinning) {
			if (reversed) {
				leftMotors.setInverted(true);
				rightMotors.setInverted(true);
			}
			
			else {
				leftMotors.setInverted(false);
				rightMotors.setInverted(false);
			}
			
			isSpinning = false;
		}
		
		drive(left, right);
	}

	/**
	 *
	 */
	public void tankDriveWithRobotDrive (double left, double right) {
		drive.tankDrive(left, right);
	}
	
	/**
	 * Spins the robot counterclockwise.
	 *
	 * @param speed the speed at which the robot spins.
	 */
	public void spinLeft(double speed) {
		isSpinning = true;
		
		leftMotors.setInverted(true);
		rightMotors.setInverted(false);
		
		drive(speed);
	}
	
	/**
	 * Spins the robot clockwise.
	 *
	 * @param speed the speed at which the robot spins.
	 */
	public void spinRight(double speed) {
		isSpinning = true;
		
		leftMotors.setInverted(false);
		rightMotors.setInverted(true);
		
		drive(speed);
	}
	
	/**
	 * Toggles the motors to go in reverse.
	 */
	public void reverse() {
		leftMotors.stopMotor();
		rightMotors.stopMotor();
		
		leftMotors.toggleInverted();
		rightMotors.toggleInverted();
		
		reversed = !reversed;
	}
	

	/**
	 * Increases the maximum speed level.
	 */
	public void upshift() {
		if (speedLevel == 2 || speedLevel == 3) {
			speedLevel--;
		}
	}
	
	/**
	 * Decreases the max speed level.
	 */
	public void downshift() {
		if (speedLevel == 1 || speedLevel == 2) {
			speedLevel++;
		}
	}
	
	/**
	 * Shift to the desired speed level.
	 *
	 * @param gear the desired speed level.
	 */
	public void shiftTo(int gear) {
		speedLevel = gear;
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
	private void drive(double speed) {
		leftMotors.set(speed * MotorPowerModifier / speedLevel);
		rightMotors.set(speed * MotorPowerModifier / speedLevel);
	}

	/**
	 * Sets each pair of motors individually to a desired speed.
	 * <p>
	 * Also puts data on the smart dashboard pertaining to the drive train.
	 *
	 * @param left the desired speed for the left motor.
	 * @param right the desired speed for the right motor.
	 */
	private void drive(double left, double right) {
		leftMotors.set(left * MotorPowerModifier / speedLevel);
		rightMotors.set(right * MotorPowerModifier / speedLevel);
	}
}
