package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 * Command to test the margin of error in the NavX's calculation of displacement.
 * 
 * @author Christopher Medlin
 */
@Deprecated
public class DisplacementTest extends SimpleCommand {
	
	public DisplacementTest () {
		super("Displacement Test");
		requires(driveTrain);
		requires(navigation);
	}
	
	@Override
	public void initialize() {
		navigation.reset();

		driveTrain.tankDriveWithRobotDrive(0.5, 0.5);
		Timer.delay(2.0);
		driveTrain.tankDriveWithRobotDrive(0, 0);
		Timer.delay(0.5);
	}
	
	@Override
	public void execute () {
		driveTrain.tankDriveWithRobotDrive(-0.5, -0.5);
		Timer.delay(2.0);
		driveTrain.tankDriveWithRobotDrive(0, 0);
		
		SmartDashboard.putNumber("Displacement X", navigation.getDisplacementX());
		SmartDashboard.putNumber("Displacement Y", navigation.getDisplacementY());
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
