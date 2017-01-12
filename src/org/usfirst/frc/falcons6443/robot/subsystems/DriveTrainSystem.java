package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.VictorSPGroup;
import org.usfirst.frc.falcons6443.robot.commands.*;

public class DriveTrainSystem extends Subsystem {

	private VictorSPGroup leftMotors = new VictorSPGroup(RobotMap.DrivetrainVictorsLeft);
	private VictorSPGroup rightMotors = new VictorSPGroup(RobotMap.DrivetrainVictorsRight);
	

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
		tankDrive(left, right);
	}

	/**
	 * Allows for custom setting of motor power level.
	 *
	 * @param left the power for the left motors.
	 * @param right the power for the right motors.
	 */
	public void tankDrive (double left, double right) {
		leftMotors.set(left);
		rightMotors.set(right);
	}
}
