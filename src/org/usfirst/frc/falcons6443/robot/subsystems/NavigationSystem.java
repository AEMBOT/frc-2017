package org.usfirst.frc.falcons6443.robot.subsystems;

import java.util.HashMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import org.usfirst.frc.falcons6443.robot.commands.PrintYaw;
import org.usfirst.frc.falcons6443.robot.hardware.NavX;
import org.usfirst.frc.falcons6443.robot.hardware.UltrasonicSensor;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem containing the NavX sensor as well as ultrasonic sensors.
 *
 * @author Shivashriganesh Mahato, Christopher Medlin, Ivan Kenevich, Patrick Higgins
 */
public class NavigationSystem extends Subsystem {

    private NavX navx;
    PIDController pid;
    private boolean isPIDInitialized;
    private HashMap<String, UltrasonicSensor> sensors;

    /**
     * Constructor for NavigationSystem.
     */
    public NavigationSystem() {
    	navx = NavX.get();
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new PrintYaw());
    }

    /**
     * @return the yaw of the robot.
     */
    public float getYaw() {
        return navx.getYaw();
    }

    /**
     * Initializes a PID controller with the NavX as it's PIDSource.
     *
     * @param output the PIDOutput for the PIDController to write to.
     */
    public void initPIDController (PIDOutput output) {
        isPIDInitialized = true;
        pid = new PIDController(DriveTrainSystem.KP,
                                DriveTrainSystem.KI,
                                DriveTrainSystem.KD,
                                DriveTrainSystem.KF,
                                navx.ahrs(), output);
        pid.setInputRange(-180.0f, 180.0f);
        pid.setOutputRange(-1.0, 1.0);
        pid.setAbsoluteTolerance(2.0f);
        pid.setContinuous(true);
        pid.enable();
    }

    public void pidSetEnabled (boolean enabled) {
        if (enabled) {
            pid.enable();
        } else {
            pid.disable();
        }
    }

    /**
     * Sets the setpoint of the PID controller.
     *
     * @param setpoint the desired setpoint.
     */
    public void pidSetPoint (float setpoint) {
        if (isPIDInitialized) {
            pid.setSetpoint(setpoint);
        }
    }
}

