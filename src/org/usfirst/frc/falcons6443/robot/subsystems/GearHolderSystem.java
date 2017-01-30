package org.usfirst.frc.falcons6443.robot.subsystems;

import org.usfirst.frc.falcons6443.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHolderSystem extends Subsystem {
	
	private Solenoid solenoid;
	private boolean open;

	public GearHolderSystem() {
		solenoid = new Solenoid(RobotMap.GearHolderSolenoid);
	}

	public void initDefaultCommand () {
		setDefaultCommand(new ReleaseGearCommand);
	}
	
	public boolean isOpen () {
		return open;
	}

	public void open () {
		solenoid.set(true);
		open = true;
	}

	public void close () {
		solenoid.set(false);
		open = false;
	}
}
