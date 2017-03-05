package org.usfirst.frc.falcons6443.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.commands.TankDriveWithTriggers;
import org.usfirst.frc.falcons6443.robot.hardware.UltrasonicSensor;

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
        motor = new Spark(RobotMap.BackRightVictor);
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
}
