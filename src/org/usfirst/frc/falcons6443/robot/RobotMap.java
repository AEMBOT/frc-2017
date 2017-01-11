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
	
	public static final int GamepadLeftStickAxisID = -1;
	public static final int GamepadRightStickAxisID = -1;
	
	public static final int GamepadLeftTriggerAxisID = -1;
	public static final int GamepadRightTriggerAxisID = -1;
	
	public static final int GamepadPortNumber = 1;
	
	//NOTE: the 0th index is the rear motor for the side, the 1st index is the front motor for the side.
	public static final VictorSP[] DrivetrainVictorsLeft = new VictorSP[] {
		new VictorSP(0), new VictorSP(0)
	};
	public static final VictorSP[] DrivetrainVictorsRight = new VictorSP[] {
		new VictorSP(0), new VictorSP(0)
	};
	
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
