package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

/**
 * Command to rotate the robot to an angle specified in a constructor parameter.
 *
 * @author Christopher Medlin, Ivan Kenevich
 */
public class RotateToAngle extends SimpleCommand implements PIDOutput {

    private double pidOutput;
    private float angle;
    private long targetTime;
    private boolean shouldFinish;

    /**
     * Constructor for RotateToAngle.
	 * 
	 * @param angle the angle at which to rotate.
     */
    public RotateToAngle (float angle) {
        super("Restricted PID Drive");
        requires(navigation);
        requires(driveTrain);
        
        this.angle = angle;
        targetTime = 0;
        shouldFinish = false;
    }

    @Override
    public void initialize () {
		navigation.reset();
        navigation.initPIDController(this);
		navigation.pidSetPoint(angle);
    }

    @Override
    public void execute () {
        driveTrain.tankDrive(pidOutput, -pidOutput);

//        if (navigation.onTarget() && !shouldFinish) {
//            targetTime = System.currentTimeMillis();
//            shouldFinish = true;
//        }

        //System.out.println(navigation.read("Left"));
    }

    public void end () {
        driveTrain.tankDrive(0,0);
    }

    @Override
    public boolean isFinished () {
        if ((System.currentTimeMillis() - targetTime >= 3000) && shouldFinish) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void pidWrite (double output) {
        pidOutput = output;
    }
}
