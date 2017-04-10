package org.usfirst.frc.falcons6443.robot.hardware;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

public class JoystickPair {
	
	private Joystick leftStick;
	private Joystick rightStick;
	
	public JoystickPair(Joystick left, Joystick right) {
		if (left.getIsXbox() || right.getIsXbox()) {
			throw new IllegalArgumentException("Tried to instantiate JoystickPair with incorrect controllers - they should never make it this far!");
		}
		
		leftStick = left;
		rightStick = right;
	}
	
	public double leftStickY() {
		return leftStick.getAxis(AxisType.kY);
	}
	
	public double rightStickY() {
		return rightStick.getAxis(AxisType.kY);
	}
	
	public boolean leftTrigger() {
		return leftStick.getTrigger();
	}
	
	public boolean rightTrigger() {
		return rightStick.getTrigger();
	}
}
