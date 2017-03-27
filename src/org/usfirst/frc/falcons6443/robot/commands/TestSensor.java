package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestSensor extends SimpleCommand {
	
	private Gamepad gamepad;

	public TestSensor() {
		super("Test the sensor");
		requires(navigation);

	}
	
	public void initialize () {
		gamepad = Robot.oi.getGamepad();
	}
	
	public void execute() {
		if (gamepad.A()) {
			SmartDashboard.putNumber("Sensor Reading", navigation.readSensor("Left"));
		}
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
