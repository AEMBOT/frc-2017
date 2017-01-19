package org.usfirst.frc.falcons6443.robot.hardware;

import edu.wpi.first.wpilibj.Joystick;

/**
 * 
 * @author Patrick Higgins
 *
 * Wrapper for an Xbox 360 Gamepad. Provides clearer interface with button and axis inputs.
 */

public class Gamepad {
	
	private Joystick gamepad;
	
	public Gamepad(Joystick gamepad) {
		assert gamepad.getIsXbox();
		this.gamepad = gamepad;
		//ideally, make it rumble
	}
	
	public Joystick getJoystick() {
		return this.gamepad;
	}
	
	public double leftStickX() {
		return gamepad.getRawAxis(0);
	}
	
	public double leftStickY() {
		return gamepad.getRawAxis(1);
	}
	
	public double rightStickX() {
		return gamepad.getRawAxis(4);
	}
	
	public double rightStickY() {
		return gamepad.getRawAxis(5);
	}
	
	public double leftTrigger() {
		return gamepad.getRawAxis(2);
	}
	
	public double rightTrigger() {
		return gamepad.getRawAxis(3);
	}
	
	public boolean leftBumper() {
		return gamepad.getRawButton(5);
	}
	
	public boolean rightBumper() {
		return gamepad.getRawButton(6);
	}
	
	public boolean A() {
		return gamepad.getRawButton(1);
	}
	
	public boolean B() {
		return gamepad.getRawButton(2);
	}
	
	public boolean X() {
		return gamepad.getRawButton(3);
	}
	
	public boolean Y() {
		return gamepad.getRawButton(4);
	}
}
