package org.usfirst.frc.falcons6443.robot.subsystems;

import java.util.HashMap;

import org.usfirst.frc.falcons6443.robot.hardware.NavX;
import org.usfirst.frc.falcons6443.robot.hardware.UltrasonicSensor;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NavigationSystem extends Subsystem {

    private NavX navx;
    private HashMap<String, UltrasonicSensor> sensors;
    
    public NavigationSystem() {
    	navx = NavX.get();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

