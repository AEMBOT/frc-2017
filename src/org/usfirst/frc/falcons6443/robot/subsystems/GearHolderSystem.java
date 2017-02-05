package org.usfirst.frc.falcons6443.robot.subsystems;

import org.usfirst.frc.falcons6443.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem which contains the components of the pneumatics control system.
 * <p>
 *     This includes the solenoid, which is used to open or close the gear holder.
 * </p>
 *
 * @author Christopher Medlin, Patrick Higgins, Shivashriganesh Mahato
 */
public class GearHolderSystem extends Subsystem {
	
	private Solenoid solenoid;

	/**
	 * Constructor for GearHolderSystem.
	 */
	public GearHolderSystem() {
		solenoid = new Solenoid(RobotMap.GearHolderSolenoid);
	}

	@Override
	public void initDefaultCommand () {
		// setDefaultCommand(new ReleaseGearCommand);
	}

	/**
	 * Sets the state of the GearHolderSystem to open.
	 */
	public void open () {
		solenoid.set(true);
	}

	/**
	 * Sets the state of the GearHolderSystem to close.
	 */
	public void close () {
		solenoid.set(false);
	}
}
