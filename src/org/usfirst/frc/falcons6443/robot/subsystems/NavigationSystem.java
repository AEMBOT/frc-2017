package org.usfirst.frc.falcons6443.robot.subsystems;

import java.util.HashMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import org.usfirst.frc.falcons6443.robot.commands.PrintYaw;
import org.usfirst.frc.falcons6443.robot.hardware.NavX;
import org.usfirst.frc.falcons6443.robot.hardware.UltrasonicSensor;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NavigationSystem extends Subsystem {

    private NavX navx;
    PIDController pid;
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

    public void initPIDController (PIDOutput output) {
        pid = new PIDController(DriveTrainSystem.KP,
                                DriveTrainSystem.KI,
                                DriveTrainSystem.KD,
                                DriveTrainSystem.KF,
                                navx.ahrs(), output);
    }
}

