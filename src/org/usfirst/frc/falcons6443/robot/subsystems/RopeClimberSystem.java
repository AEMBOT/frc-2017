package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.TankDriveWithTriggers;

/**
 * Subsystem containing the motor for the rope climber as well as the sensor.
 *
 * @author Christopher Medlin
 */
public class RopeClimberSystem extends Subsystem {

    private Victor motor;

    private boolean climbing;
    private boolean descending;

    public RopeClimberSystem () {
        motor = new Victor(RobotMap.BackRightVictor);
        climbing = false;
        descending = false;
    }

    @Override
    public void initDefaultCommand () {
        new TankDriveWithTriggers().start();
    }

    /**
     * Turns on the rope climber motor.
     */
    public void climb () {
        motor.set(0.3);
        climbing = true;
        descending = false;
    }

    /**
     * Turns off the rope climber motor.
     */
    public void stop () {
        motor.set(0);
        climbing = false;
        descending = false;
    }

    /**
     * Sets the rope climber motor to reverse.
     */
    public void descend () {
        motor.set(-0.3);
        climbing = false;
        descending = true;
    }

    /**
     * @return Whether or not the rope climber mechanism is in reverse.
     */
    public boolean isDescending () {
        return descending;
    }

    /**
     * @return Whether or not the rope climber mechanism is climbing.
     */
    public boolean isClimbing () {
        return climbing;
    }
}
