package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.falcons6443.robot.RobotMap;

/**
 * Subsystem containing the motor for the rope climber as well as the sensor.
 *
 * @author Christopher Medlin, Ivan Kenevich
 */
public class RopeClimberSystem extends Subsystem {

    // Just like a Victor
    private Spark motor;

    // Boolean for whether or not the rope climber is in idleing mode.
    private boolean idle;

    // The speed that the rope climber idles at
    private final double IDLE_SPEED = 0.3;

    public RopeClimberSystem() {
        motor = new Spark(RobotMap.RopeClimberSpark);
        idle = false;
        set(0);
    }

    @Override
    public void initDefaultCommand() {
    }

    /**
     * Used for directly setting the power of the rope climber motor.
     *
     * @param power the desired power.
     */
    public void set(double power) {
        motor.set(power);
    }

    /**
     * Toggles setting the rope climber to an idle speed, similar to a motor vehicle.
     */
    public void toggleIdle() {
        if (!idle) {
            set(IDLE_SPEED);
        }
        else {
            set(0);
        }

        idle = !idle;
    }
}
