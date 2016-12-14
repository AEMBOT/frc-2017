package org.usfirst.frc.team6443.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6443.robot.RobotMap;

public class DriveTrain extends Subsystem {

	Victor leftMotor = RobotMap.driveTrainMotorLeft;
	Victor rightMotor = RobotMap.driveTrainMotorRight;
	//kmdf
	@Override
	public void initDefaultCommand() {
	}
	
	public void stop() {
		leftMotor.set(0);
		rightMotor.set(0);
	}

	public void forwardDrive() {
		rightMotor.set(1);
		leftMotor.set(1);
	}

	public void leftTurn() {
		leftMotor.set(-1);
		rightMotor.set(1);
	}

	public void reverseDrive() {
		leftMotor.set(-1);
		rightMotor.set(-1);
	}
	
	public void rightTurn() {
		leftMotor.set(1);
		rightMotor.set(-1);
	}
	
}
