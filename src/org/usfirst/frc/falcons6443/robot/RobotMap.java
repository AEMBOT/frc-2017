package org.usfirst.frc.falcons6443.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//any null constants have yet to be defined and should be defined in the future
	public static final int FrontRightVictor = 0;
	public static final int FrontLeftVictor = 3;
	public static final int BackRightVictor = 1;
	public static final int BackLeftVictor = 2;
	
	public static final int GearHolderSolenoid = 0;

	/**
	 * Checks RobotMap for out-of-bounds values.
	 * 
	 * @return whether RobotMap contains only valid ( < 0 ) values
	 */
	@SuppressWarnings("unused")
	public static boolean isOK() {
		
		//fix later
		return true;
	}
}
