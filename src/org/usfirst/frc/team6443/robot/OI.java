package org.usfirst.frc.team6443.robot;

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
	private Joystick joystick;
     	private HashMap<String, Button> buttons; 
	
	public OI () {
		joystick = new Joystick(0 /*specify port*/);
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
