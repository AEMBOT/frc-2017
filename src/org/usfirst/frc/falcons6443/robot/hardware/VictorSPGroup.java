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
	
	public VictorSPGroup(VictorSP[] controllers) {
		this.controllers = controllers;
	}

	public VictorSPGroup(VictorSP front, VictorSP back) {
		controllers = {front, back};
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

	/**
	 * @deprecated @abstract edu.wpi.first.wpilibj.SpeedController.set(double arg0, byte arg1) is deprecated
	 * (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.SpeedController#set(double, byte)
	 */
	@Override
	@Deprecated
	public void set(double arg0, byte arg1) {
		
		for (VictorSP controller : controllers) {
			controller.set(arg0, arg1);
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

}
