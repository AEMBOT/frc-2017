package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.ToggleGearHolder;

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

	private DoubleSolenoid solenoid;
	private boolean open;

	/**
	 * Constructor for GearHolderSystem.
	 */
	public GearHolderSystem() {
		solenoid = new DoubleSolenoid(RobotMap.GearHolderSolenoidOpen,
				RobotMap.GearHolderSolenoidClose);

		open = false;
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ToggleGearHolder());
	}


	public boolean isOpen() {
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

