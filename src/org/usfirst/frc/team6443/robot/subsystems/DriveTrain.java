package org.usfirst.frc.team6443.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6443.robot.RobotMap;

public class DriveTrain extends Subsystem {

	Victor[] leftMotors = RobotMap.driveTrainVictorsLeft;
	Victor[] rightMotors = RobotMap.driveTrainVictorsRight;
	
	@Override
	public void initDefaultCommand() {
	}
	
	/**
	 * Allows for custom setting of motor power level.
	 *
	 * @param left the power for the left motors.
	 * @param right the power for the right motors.
	 */
	public void drive(int left, int right) {
		for (Victor motor : leftMotors)
			motor.set(left);
		for (Victor motor : rightMotors)
			motor.set(right)
	}
	
}
