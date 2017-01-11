package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.*;



public class DriveTrainSystem extends Subsystem {

	VictorSP[] leftMotors = RobotMap.DrivetrainVictorsLeft;
	VictorSP[] rightMotors = RobotMap.DrivetrainVictorsRight;
	

	public DriveTrainSystem () {
		
	}
	
	@Override
	public void initDefaultCommand () {
		setDefaultCommand(new TankDriveWithJoysticks());
	}
	/**
	 * Passes desired tank drive inputs to instance of RobotDrive
	 * 
	 * @param left left axis value.
	 * @param right right axis value.
	 */
	public void updateGamepadInput(double left, double right) {
		drive(left, right);
	}

	/**
	 * Allows for custom setting of motor power level.
	 *
	 * @param left the power for the left motors.
	 * @param right the power for the right motors.
	 */
	public void drive (double left, double right) {
		for (VictorSP motor : leftMotors)
			motor.set(left);
		for (VictorSP motor : rightMotors)
			motor.set(right);
	}
}
