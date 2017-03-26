package org.usfirst.frc.falcons6443.robot.subsystems;

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

    private Victor motor;

    private boolean climbing;
    private boolean descending;

    public RopeClimberSystem () {
      //  motor = new Victor(RobotMap.BackRightVictor);
        climbing = false;
        descending = false;
    }

    @Override
    public void initDefaultCommand () {}

    /**
     * Sets the power of the rope climber.
     */
    public void set (double power) {
        //motor.set(power);
    }

}
