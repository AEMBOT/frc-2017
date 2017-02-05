package org.usfirst.frc.falcons6443.robot.hardware;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * SpeedControllerGroup serves as a wrapper to an array SpeedController objects, enabling 
 * easy passing of methods to a group of SpeedControllers.
 * 
 * @author Patrick Higgins
 */

public class SpeedControllerGroup implements SpeedController {
	
	private SpeedController[] controllers;
	
	public SpeedControllerGroup(SpeedController[] controllers) {
		this.controllers = controllers;
	}

	public SpeedControllerGroup(SpeedController front, SpeedController back) {
		controllers = new SpeedController[]{front, back};
	}
	
	@Override
	public void pidWrite(double arg0) {
		
		for (SpeedController controller : controllers) {
			controller.pidWrite(arg0);
		}

	}

	@Override
	public void disable() {
		
		for (SpeedController controller : controllers) {
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
		
		for (SpeedController controller : controllers) {
			controller.set(arg0);
		}

	}

	@Override
	public void setInverted(boolean arg0) {
		
		for (SpeedController controller : controllers) {
			controller.setInverted(arg0);
		}

	}

	@Override
	public void stopMotor() {

		for (SpeedController controller : controllers) {
			controller.stopMotor();
		}

	}
	
	public void toggleInverted() {
		for (int i = 0; i < controllers.length; i++) {
			SpeedController controller = controllers[i];
			controller.setInverted(!controller.getInverted());
		}
	}

}
