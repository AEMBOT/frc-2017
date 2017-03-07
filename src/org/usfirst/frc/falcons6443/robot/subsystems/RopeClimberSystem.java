package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
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

    // This value extends the range of the pulse interval.
    // You probably don't need to worry about this, just a magic number.
    private final double PULSE_INTERVAL_MODIFIER = 30;

    public RopeClimberSystem() {
        motor = new Spark(RobotMap.RopeClimberSpark);
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
        motor.set(-power);
    }

    /**
     * Pulsates the motor.
     * <p>
     * The motor will run at full power for a certain amount of time and then stop the thread
     * for the same amount of time. This method is meant to be called repeatedly.
     *
     * @param pulseInterval the interval between pulses. 0 < pulseInterval <= 1
     */
    public void pulse(double pulseInterval) {
        set(pulseInterval);
        //Timer.delay(0.2);
        //set(0);
        //Timer.delay(1 / (pulseInterval * PULSE_INTERVAL_MODIFIER));
    }
}
