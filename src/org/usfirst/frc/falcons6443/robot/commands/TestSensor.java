package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestSensor extends SimpleCommand {
	
	private Gamepad gamepad;

	public TestSensor(String name) {
		super(name);
		requires(navigation);

	}
	
	public void initialize () {
		gamepad = Robot.oi.getGamepad();
	}
	
	public void execute() {
		if (gamepad.A()) {
			SmartDashboard.putNumber("Sensor Reading", navigation.read("Left"));
		}
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
