package org.usfirst.frc.team6443.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.GenericHID;

import org.usfirst.frc.team6443.robot.RobotMap;

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
