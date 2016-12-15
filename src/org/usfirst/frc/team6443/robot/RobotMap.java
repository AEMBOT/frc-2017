package org.usfirst.frc.team6443.robot;

import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final Victor[] driveTrainVictorsLeft = new Victor[] {
		new Victor(/*channel?*/), new Victor(/*channel?*/)
	};
	public static final Victor[] driveTrainVictorsRight = new Victor[] {
		new Victor(/*channel?*/), new Victor(/*channel?*/)
	};
