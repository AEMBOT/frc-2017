package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.hardware.VictorSPGroup;
import org.usfirst.frc.falcons6443.robot.commands.*;

public class DriveTrainSystem extends Subsystem {

	private VictorSPGroup leftMotors;
	private VictorSPGroup rightMotors;
	
	public DriveTrainSystem() {
		VictorSP frontLeft = new VictorSP(RobotMap.FrontLeftVictor);
		VictorSP backLeft = new VictorSP(RobotMap.BackLeftVictor);
		VictorSP frontRight = new VictorSP(RobotMap.FrontRightVictor);
		VictorSP backRight = new VictorSP(RobotMap.BackRightVictor);
		
		leftMotors = new VictorSPGroup(frontLeft, backLeft);
		
		rightMotors = new VictorSPGroup(frontRight, backRight);
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
