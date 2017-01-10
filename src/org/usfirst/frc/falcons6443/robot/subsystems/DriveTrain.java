package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.falcons6443.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID;

public class DriveTrain extends Subsystem {

	Victor[] leftMotors = RobotMap.driveTrainVictorsLeft;
	Victor[] rightMotors = RobotMap.driveTrainVictorsRight;
	
	RobotDrive drive;

	public DriveTrain () {
		drive = new RobotDrive(leftMotors[1], leftMotors[0], rightMotors[1], rightMotors[0]);
	}
	
	@Override
	public void initDefaultCommand () {
		
	}

	public void arcadeDrive (GenericHID hid) {
		drive.arcadeDrive(hid);
	}

	public void tankJSDrive(GenericHID leftJS, GenericHID rightJS) {
		drive.tankDrive(leftJS, rightJS);
	}

	public void tankTrigDrive(GenericHID leftJS, GenericHID rightJS) {
		if(leftJS == null || rightJS == null)
			throw new NullPointerException("Null HID provided");

		double leftTrigVal = leftJS.getRawAxis(-1);
		double rightTrigVal = rightJS.getRawAxis(-1);

		drive.setLeftRightMotorOutputs(leftTrigVal, rightTrigVal);
	}

	/**
	 * Allows for custom setting of motor power level.
	 *
	 * @param left the power for the left motors.
	 * @param right the power for the right motors.
	 */
	public void drive (int left, int right) {
		for (Victor motor : leftMotors)
			motor.set(left);
		for (Victor motor : rightMotors)
			motor.set(right);
	}
}
