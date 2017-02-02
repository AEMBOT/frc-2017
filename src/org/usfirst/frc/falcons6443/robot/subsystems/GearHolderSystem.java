package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.ToggleGearHolder;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHolderSystem extends Subsystem {
	
	private DoubleSolenoid solenoid;
	private boolean open;

	public GearHolderSystem() {
		solenoid = new DoubleSolenoid(RobotMap.GearHolderSolenoidOpen,
				                     RobotMap.GearHolderSolenoidClose);
		
		open = false;
	}

	public void initDefaultCommand () {
		setDefaultCommand(new ToggleGearHolder());
	}
	
	public boolean isOpen () {
		return open;
	}

	public void open() {
		solenoid.set(DoubleSolenoid.Value.kForward);
		
		open = true;
	}
	
	public void close() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
		
		open = false;
	}
}
