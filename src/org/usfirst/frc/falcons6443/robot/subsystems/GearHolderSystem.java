package org.usfirst.frc.falcons6443.robot.subsystems;

import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.ToggleGearHolder;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHolderSystem extends Subsystem {
	
	private Solenoid solenoid;
	private boolean open;

	public GearHolderSystem() {
		solenoid = new Solenoid(RobotMap.GearHolderSolenoid);
	}

	public void initDefaultCommand () {
		setDefaultCommand(new ToggleGearHolder());
	}
	
	public boolean isOpen () {
		return open;
	}

	public void set (boolean set) {
		solenoid.set(set);
		open = set;
	}
}
