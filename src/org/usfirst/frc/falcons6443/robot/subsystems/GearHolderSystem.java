package org.usfirst.frc.falcons6443.robot.subsystems;

import org.usfirst.frc.falcons6443.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHolderSystem extends Subsystem {
	
	private Solenoid solenoid;

	/**
	 * maps the (variable?) solenoid to the RobotMap
	 */
	public GearHolderSystem() {
		solenoid = new Solenoid(RobotMap.GearHolderSolenoid);
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void initDefaultCommand () {
		// setDefaultCommand(new ReleaseGearCommand);
	}

	/**
	 * when the solenoid is open it's set as true
	 */
	
	public void open () {
		solenoid.set(true);
	}

	/**
	 * when the solenoid is open it's set as false
	 */
	
	public void close () {
		solenoid.set(false);
	}
}
