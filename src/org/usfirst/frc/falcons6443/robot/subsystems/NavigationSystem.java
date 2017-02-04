package org.usfirst.frc.falcons6443.robot.subsystems;

import java.util.HashMap;

import org.usfirst.frc.falcons6443.robot.commands.PrintYaw;
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

        setDefaultCommand(new PrintYaw());
    }

    public float getYaw() {
        return navx.getYaw();
    }
}

