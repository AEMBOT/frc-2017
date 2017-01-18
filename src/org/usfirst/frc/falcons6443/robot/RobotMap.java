package org.usfirst.frc.falcons6443.robot;

import edu.wpi.first.wpilibj.VictorSP;

//TODO Currently the parameters for the Victor constructors are placeholders. We need the correct channel numbers for the Victors.

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int GamepadLeftStickAxisXID = 0;
	public static final int GamepadLeftStickAxisYID = 1;
	
	public static final int GamepadRightStickAxisXID = 4;
	public static final int GamepadRightStickAxisYID = 5;
	
	public static final int GamepadLeftTriggerAxisID = 2;
	public static final int GamepadRightTriggerAxisID = 3;
	
	public static final int GamepadPortNumber = 0;

	public static final int FrontRightVictor = 0;
	public static final int FrontLeftVictor = 0;
	public static final int BackRightVictor = 0;
	public static final int BackLeftVictor = 0;
	
	/**
	 * Checks RobotMap for out-of-bounds values.
	 * 
	 * @return whether RobotMap contains only valid ( < 0 ) values
	 */
	@SuppressWarnings("unused")
	public static boolean isOK() {
		
		if (GamepadLeftStickAxisID < 0 || GamepadRightStickAxisID < 0 || GamepadLeftTriggerAxisID < 0 || GamepadRightTriggerAxisID < 0) {
			return false;
		}
		
			return true;
			
	}
}
