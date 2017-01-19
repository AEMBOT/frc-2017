package org.usfirst.frc.falcons6443.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;

//TODO Currently the port for the joystick is a placeholder, so we should change that when we know what the port is.

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 *
 * @author Christopher Medlin
 */
public class OI {

	private final int GAMEPAD_LEFT_STICK_AXIS_X_ID = 0;
	private final int GAMEPAD_LEFT_STICK_AXIS_Y_ID = 1;
	
	private final int GAMEPAD_RIGHT_STICK_AXIS_X_ID = 4;
	private final int GAMEPAD_RIGHT_STICK_AXIS_Y_ID = 5;
	
	private final int GAMEPAD_LEFT_TRIGGER_AXIS_ID = 2;
	private final int GAMEPAD_RIGHT_TRIGGER_AXIS_ID = 3;
	
	private final int GAMEPAD_PORT_NUMBER = 0;

	private Joystick joystick;
     	
	private HashMap<String, Button> buttons; 
	
	public OI () {
		joystick = new Joystick(GAMEPAD_PORT_NUMBER);
		buttons = new HashMap<String, Button>(4);
	}	
	
	/**
	 * Returns the Joystick associated with this OI object.
	 *
	 * @return the Joystick associated with this OI object.
	 */
	public Joystick getJoystick () {
		return joystick;
	}
	
	/**
	 * Returns the Button object associated with the key.
	 *
	 * @param key the name of the button.
	 * @return the button associated with the key.
	 */
	public Button getButton (String key) {
		return buttons.get(key);
	}
}
