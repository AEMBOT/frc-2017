/**
 * 
 */
package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;

/**
 * Command to toggle the gear holder to close when it's open and to open when it's closed.
 * 
 * @author Christopher Medlin
 */
public class ToggleGearHolder extends SimpleCommand {
	private boolean finished;
	
	public ToggleGearHolder () {
		super("Toggle Gear Holder");
		requires(gearHolder);
	}
	
	public void execute () {
		gearHolder.set(!gearHolder.isOpen());
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

}
