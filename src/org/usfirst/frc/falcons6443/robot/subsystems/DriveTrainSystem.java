package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.hardware.VictorSPGroup;
import org.usfirst.frc.falcons6443.robot.commands.*;

public class DriveTrainSystem extends Subsystem {
	
	public static final double MotorPowerModifier = .75; //multiplier for max motor power
	
	private VictorSPGroup leftMotors;
	private VictorSPGroup rightMotors;
	
	private boolean isSpinning;
	private boolean reversed;
	
	private int speedLevel;
	
	public DriveTrainSystem() {
		VictorSP frontLeft = new VictorSP(RobotMap.FrontLeftVictor);
		VictorSP backLeft = new VictorSP(RobotMap.BackLeftVictor);
		VictorSP frontRight = new VictorSP(RobotMap.FrontRightVictor);
		VictorSP backRight = new VictorSP(RobotMap.BackRightVictor);
		
		//invert motors here
		  
		leftMotors = new VictorSPGroup(frontLeft, backLeft);
		
		rightMotors = new VictorSPGroup(frontRight, backRight);
		
		rightMotors.setInverted(true);
		
		isSpinning = false;
		reversed = false;
		
		speedLevel = 3; //start in lowest speed mode
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
	 * spins the robot counterclockwise
	 * @param speed
	 */
	
	public void spinLeft(double speed) {
		isSpinning = true;
		
		leftMotors.setInverted(true);
		rightMotors.setInverted(false);
		
		drive(speed);
	}
	
	/**
	 * spins the robot clockwise
	 * @param speed
	 */
	
	public void spinRight(double speed) {
		isSpinning = true;
		
		leftMotors.setInverted(false);
		rightMotors.setInverted(true);
		
		drive(speed);
	}
	
	/**
	 * toggles the motors to go in reverse.
	 */

	public void reverse() {
		leftMotors.stopMotor();
		rightMotors.stopMotor();
		
		leftMotors.toggleInverted();
		rightMotors.toggleInverted();
		
		reversed = !reversed;
	}
	

	/**
	 * locking the speed 1/2 max to 1/3 max(of default)
	 */
	
	public void upshift() {
		if (speedLevel == 2 || speedLevel == 3) {
			speedLevel--;
		}
	}
	
	/**
	 * locking the speed from default to 1/2 max of default
	 */
	
	public void downshift() {
		if (speedLevel == 1 || speedLevel == 2) {
			speedLevel++;
		}
	}
	
	/**
	 * 
	 * @param gear
	 */
	
	public void shiftTo(int gear) {
		speedLevel = gear;
	}
	
	/**
	 * when it's reversed it will return reverse
	 * @return
	 */
	
	public boolean isReversed() {
		return reversed;
	}
	
	/**
	 * getting speedlevel information
	 * @return
	 */
	
	public int getSpeedLevel() {
		return speedLevel;
	}
	
	
	private void drive(double speed) {
		leftMotors.set(speed * MotorPowerModifier / speedLevel);
		rightMotors.set(speed * MotorPowerModifier / speedLevel);
	}
	
	
	private void drive(double left, double right) {
		leftMotors.set(left * MotorPowerModifier / speedLevel);
		rightMotors.set(right * MotorPowerModifier / speedLevel);
		
		SmartDashboard.putNumber("Speed Level", speedLevel);
		SmartDashboard.putNumber("Left Input", left * MotorPowerModifier / speedLevel);
		SmartDashboard.putNumber("Right Input", right * MotorPowerModifier / speedLevel);
	}
	
}
