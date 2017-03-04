package org.usfirst.frc.falcons6443.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//any null constants have yet to be defined and should be defined in the future
	public static final int FrontRightVictor = 2;
	public static final int FrontLeftVictor = 1;
	public static final int BackRightVictor = 3;
	public static final int BackLeftVictor = 0;
	
	public static final int GearHolderSolenoidOpen = 0;
	public static final int GearHolderSolenoidClose = 1;

	public static final int FrontUltrasonic = -1;
	public static final int LeftUltrasonic = -1;
	public static final int RightUltrasonic = -1;
	public static final int BackUltrasonic = -1;

	public static final int RopeClimberVictor = 13;

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
