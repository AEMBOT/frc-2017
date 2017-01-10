package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.*;



public class DriveTrainSystem extends Subsystem {

	Victor[] leftMotors = RobotMap.DrivetrainVictorsLeft;
	Victor[] rightMotors = RobotMap.DrivetrainVictorsRight;
	
	RobotDrive drive;

	public DriveTrainSystem () {
		drive = new RobotDrive(leftMotors[1], leftMotors[0], rightMotors[1], rightMotors[0]);
	}
	
	@Override
	public void initDefaultCommand () {
		setDefaultCommand(new MoveTankDriveJSCommand());
	}
	/**
	 * Passes desired tank drive inputs to instance of RobotDrive
	 * 
	 * @param left left axis value.
	 * @param right right axis value.
	 */
	public void updateGamepadInput(double left, double right) {
		drive.tankDrive(left, right);
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
