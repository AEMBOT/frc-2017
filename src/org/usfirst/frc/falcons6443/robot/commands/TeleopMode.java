package org.usfirst.frc.falcons6443.robot.commands;

import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;
import org.usfirst.frc.falcons6443.robot.subsystems.FlywheelSystem;


/**
 * Teleoperated mode for the robot.
 * The execute method of this class handles all possible inputs from the driver during the game.
 *
 * @author Ivan Kenevich, Christopher Medlin, Shivashriganesh Mahato
 */
public class TeleopMode extends SimpleCommand {

    private Gamepad gamepad;
    private boolean reversed;
    private FlywheelSystem flywheel;

    public TeleopMode() {
        super("Teleop Command");

        requires(driveTrain);
        requires(flywheel);
        //requires(elevator);
    }

    @Override
    public void initialize() {
        gamepad = Robot.oi.getGamepad();
        reversed = false;
    }

    @Override
    public void execute() {
        //for testing
        //elevator.manual(xbox.rightStickY(xbox.primary));
        //manual rotation
        flywheel.manual(gamepad.leftStickY());

        System.out.println("intake: " + gamepad.leftStickY());
        System.out.println("lift: " + gamepad.rightStickY());

        /*if(xbox.X(xbox.primary)){
            elevator.up(true);
        }

        if(xbox.Y(xbox.primary)){
            elevator.down(true);
        }

        if (!xbox.X(xbox.primary) && !xbox.Y(xbox.primary) && xbox.rightStickY(xbox.primary) == 0) {
            elevator.stop();
        }*/

        // set the driveTrain power.
        driveTrain.tankDrive(gamepad.leftStickY(), gamepad.leftStickY());

        /*
        System.out.println("Left: " + driveTrain.get());
        System.out.println("Right: " + driveTrain.getRightDistance());

        System.out.println("Left: " + driveTrain.getLeftDistance());
        System.out.println("Right: " + driveTrain.getRightDistance());
        */

        // the Y button will toggle the drive train to reverse mode
        /*if (xbox.Y()) {
            // safeguard for if the driver holds down the Y button.
            if (!reversed) {
                driveTrain.reverse();
                reversed = true;
            }
        } else {
            reversed = false;
        }*/
        /*
        if(gamepad.Y(gamepad.primary)){
            driveTrain.reset();
        }
        */
        //intake button
        if (gamepad.leftBumper()) {
            //if (flywheel.hasBlock()) {
            //  flywheel.stop();
            //} else {
            flywheel.intake();
            //}
        }

        //output button
        if (gamepad.rightBumper()) {
            flywheel.output();
        }

        //stop
        if (!gamepad.leftBumper() && !gamepad.rightBumper()){
            flywheel.stop();
        }

        //elevator.moveToHeight();
    }

    public boolean isFinished() {
        return false;
    }
}
