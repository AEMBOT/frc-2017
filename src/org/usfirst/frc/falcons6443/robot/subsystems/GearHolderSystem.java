package org.usfirst.frc.falcons6443.robot.subsystems;

import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.ToggleGearHolder;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHolderSystem extends Subsystem {
	
	private Solenoid openSolenoid, closeSolenoid;
	private boolean open;

	public GearHolderSystem() {
		openSolenoid = new Solenoid(RobotMap.GearHolderSolenoidOpen);
		closeSolenoid = new Solenoid(RobotMap.GearHolderSolenoidClose);
	}

	public void initDefaultCommand () {
		setDefaultCommand(new ToggleGearHolder());
	}
	
	public boolean isOpen () {
		return open;
	}

	public void open() {
		openSolenoid.set(true);
		closeSolenoid.set(false);
		
		open = true;
	}
	
	public void close() {
		closeSolenoid.set(true);
		openSolenoid.set(false);
		
		open = false;
	}
}
