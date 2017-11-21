package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.falcons6443.robot.Robot;
import org.usfirst.frc.falcons6443.robot.RobotMap;
import org.usfirst.frc.falcons6443.robot.hardware.Gamepad;
import org.usfirst.frc.falcons6443.robot.utilities.Smashboard;

/**
 * Teleoperated mode for the robot.
 * The execute method of this class handles all possible inputs from the driver during the game.
 *
 * @author Ivan Kenevich, Christopher Medlin, Shivashriganesh Mahato
 */
public class TeleopMode extends SimpleCommand {

    private Gamepad gamepad;
    private boolean reversed, gearToggled, ropeClimberIdled;
    private Ultrasonic ultrasonic;

    public TeleopMode() {
        super("Teleop Command");

        requires(driveTrain);
        requires(gearHolder);
        requires(ropeClimber);
        ultrasonic = new Ultrasonic(RobotMap.UltrasonicA, RobotMap.UltrasonicB);
    }

    @Override
    public void initialize() {
        gamepad = Robot.oi.getGamepad();
        reversed = false;
        gearToggled = false;
        ropeClimberIdled = false;
    }

    @Override
    public void execute() {
        double throttle = gamepad.rightTrigger();
        double turn = gamepad.leftStickX();
        double ropeClimberThrottle = gamepad.leftTrigger();

        // left bumper downshifts, right bumper upshifts.
        if (gamepad.leftBumper()) {
            driveTrain.downshift();
        } else if (gamepad.rightBumper()) {
            driveTrain.upshift();
        }

        // the A button will toggle the gear holder
        if (gamepad.A()) {
            // safeguard for if the driver holds the A button
            if (!gearToggled) {
                gearHolder.open();
                gearToggled = true;
            }
        } else {
            gearHolder.close();
            gearToggled = false;
        }

        // the X button will toggle the rope climber to idleing mode
        if (gamepad.X()) {
            // safeguard for if the driver holds down the X button.
            if (!ropeClimberIdled) {
                ropeClimber.toggleIdle();
                ropeClimberIdled = true;
            }
        }
        else {
            ropeClimberIdled = false;
        }

        // the Y button will toggle the drive train to reverse mode
        if (gamepad.Y()) {
            // safeguard for if the driver holds down the Y button.
            if (!reversed) {
                driveTrain.reverse();
                reversed = true;
            }
        } else {
            reversed = false;
        }

        // set the driveTrain power.
        if (throttle == 0) {
            driveTrain.spin(turn);
        } else {
            driveTrain.drive(throttle, turn);
        }

        // if the input from the joystick exceeds idle speed
        if (ropeClimberThrottle > 0.3) {
            // set the rope climber to that speed
            ropeClimber.set(ropeClimberThrottle);
        }

        Smashboard.putBoolean("reversed", driveTrain.isReversed());
        SmartDashboard.putNumber("Ultrasonic", ultrasonic.getRangeInches());
        //Back up:
        // System.out.println("Ultrasonic: " + ultrasonic.getRangeInches());
    }

    public boolean isFinished() {
        return false;
    }
}
