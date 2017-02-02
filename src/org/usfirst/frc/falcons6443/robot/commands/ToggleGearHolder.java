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
	private boolean startState;
	
	public ToggleGearHolder () {
		super("Toggle Gear Holder");
		requires(gearHolder);
	}
	
	public void initialize() {
		startState = gearHolder.isOpen();
	}
	public void execute () {
		if (startState == false) {
			gearHolder.open();
		}
		
		else {
			gearHolder.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		return (gearHolder.isOpen() != startState);
	}

}
