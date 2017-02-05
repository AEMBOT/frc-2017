package org.usfirst.frc.falcons6443.robot.hardware;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * VictorSPGroup serves as a wrapper to an array VictorSP objects, enabling 
 * easy passing of methods to a group of VictorSPs.
 * 
 * @author Patrick Higgins
 */

public class VictorSPGroup implements SpeedController {
	
	private VictorSP[] controllers;

	/**
	 * Constructor for VictorSPGroup.
	 *
	 * @param controllers the Victor speed controllers in the form of an array.
	 */
	public VictorSPGroup(VictorSP[] controllers) {
		this.controllers = controllers;
	}

	/**
	 * Overloaded constructor for VictorSPGroup.
	 *
	 * @param front the front Victor speed controller.
	 * @param back the back Victor speed controller.
	 */
	public VictorSPGroup(VictorSP front, VictorSP back) {
		controllers = new VictorSP[]{front, back};
	}
	
	@Override
	public void pidWrite(double arg0) {
		for (VictorSP controller : controllers) {
			controller.pidWrite(arg0);
		}
	}

	@Override
	public void disable() {
		for (VictorSP controller : controllers) {
			controller.disable();
		}
	}

	@Override
	public double get() {
		//does get() return set power or actual power? 
		//would getting an average of the get() value for each index be more useful?
		
		return controllers[0].get();
	}

	@Override
	public boolean getInverted() {
		return controllers[0].getInverted();
	}

	@Override
	public void set(double arg0) {
		for (VictorSP controller : controllers) {
			controller.set(arg0);
		}
	}

	@Override
	public void setInverted(boolean arg0) {
		for (VictorSP controller : controllers) {
			controller.setInverted(arg0);
		}
	}

	@Override
	public void stopMotor() {
		for (VictorSP controller : controllers) {
			controller.stopMotor();
		}
	}

	/**
	 * Toggles whether the speed controllers in this group are inverted.
	 */
	public void toggleInverted() {
		for (int i = 0; i < controllers.length; i++) {
			VictorSP controller = controllers[i];
			controller.setInverted(!controller.getInverted());
		}
	}

}
