package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.TankDriveWithTriggers;

/**
 * Subsystem containing the motor for the rope climber as well as the sensor.
 *
 * @author Christopher Medlin
 */
public class RopeClimberSystem extends Subsystem {

    private Spark motor;

    private boolean climbing;
    private boolean descending;

    private final double PULSE_INTERVAL_MODIFIER = 4;

    public RopeClimberSystem () {
        motor = new Spark(RobotMap.RopeClimberSpark);
        climbing = false;
        descending = false;
    }

    @Override
    public void initDefaultCommand () {
        new TankDriveWithTriggers().start();
    }

    public void set (double power) {
        motor.set(power);
    }
    
    public void pulse (double pulseInterval) {
        set(1);
        Timer.delay(1/pulseInterval*PULSE_INTERVAL_MODIFIER);
        set(0);
        Timer.delay(1/pulseInterval*PULSE_INTERVAL_MODIFIER);
    }
}
