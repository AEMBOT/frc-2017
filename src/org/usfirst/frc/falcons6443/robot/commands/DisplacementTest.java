package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command to test the margin of error in the NavX's calculation of displacement.
 * 
 * @author Christopher Medlin
 */
public class DisplacementTest extends SimpleCommand {
	
	public long initTime;
	public boolean finished;
	public boolean movingForward;
	
	public DisplacementTest () {
		super("Displacement Test");
		requires(driveTrain);
		requires(navigation);
	}
	
	@Override
	public void initialize() {
		initTime = System.currentTimeMillis();
		finished = false;
		movingForward = true;
		driveTrain.tankDrive(.1, .1);
	}
	
	@Override
	public void execute () {
		long time = System.currentTimeMillis() - initTime;
		
		if (time > 2000) {
			movingForward = false;
			driveTrain.tankDrive(-.1, -.1);
		}
		
		else if (!movingForward && time > 4000) {
			driveTrain.tankDrive(0, 0);
			finished = true;
		}
		
		SmartDashboard.putNumber("Displacement X", navigation.getDisplacementX());
		SmartDashboard.putNumber("Displacement Y", navigation.getDisplacementY());
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return finished;
	}
}
