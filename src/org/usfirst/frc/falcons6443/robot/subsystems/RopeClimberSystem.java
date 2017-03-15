package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.falcons6443.robot.RobotMap;

/**
 * Subsystem containing the motor for the rope climber as well as the sensor.
 *
 * @author Christopher Medlin
 */
public class RopeClimberSystem extends Subsystem {

    private Spark motor;

    private boolean climbing;
    private boolean descending;

    public RopeClimberSystem () {
        motor = new Spark(RobotMap.RopeClimberVictor);
        climbing = false;
        descending = false;
    }

    @Override
    public void initDefaultCommand () {

    }

    /**
     * @param throttle
     */
    public void set (double throttle) {
        motor.set(throttle);
    }
}
