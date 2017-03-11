package org.usfirst.frc.falcons6443.robot.utilities;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * @author Shivashriganesh Mahato
 */
public class Smashboard {

    private static final NetworkTable table = NetworkTable.getTable("smashboard");

    public static void putNumber(String key, double value) {
        table.putNumber(key, value);
    }

    public static void putBoolean(String key, boolean value) {
        table.putBoolean(key, value);
    }

    public static double getNumber(String key, double defaultValue) {
        return table.getNumber(key, defaultValue);
    }

}
