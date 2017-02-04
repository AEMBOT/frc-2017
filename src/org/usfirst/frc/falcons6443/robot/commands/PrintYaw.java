package org.usfirst.frc.falcons6443.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.falcons6443.robot.subsystems.NavigationSystem;

/**
 * Created by Ivan on 2/4/2017.
 */
public class PrintYaw extends SimpleCommand {

    public PrintYaw () {
        super("Print Yaw");
        SmartDashboard.putNumber("Get Yaw", navigation.getYaw());
    }
}
