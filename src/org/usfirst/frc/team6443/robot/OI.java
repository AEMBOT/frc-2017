package org.usfirst.frc.team6443.robot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick controller = new Joystick(0 /*specify port*/);
     	public Button button1 = new JoystickButton(controller),
       		      button2 = new JoystickButton(controller),
       		      button3 = new JoystickButton(controller),
		      button4 = new JoystickButton(controller),
		      button5 = new JoystickButton(controller),
		      button6 = new JoystickButton(controller),
		      button7 = new JoystickButton(controller),
		      button8 = new JoystickButton(controller);		      
}
