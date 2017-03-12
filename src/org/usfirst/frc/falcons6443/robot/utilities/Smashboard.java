package org.usfirst.frc.falcons6443.robot.utilities;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The {@link Smashboard} class is the bridge between robot programs and the Smashboard on
 * the laptop.
 * <p>
 * <p>When a value is put into the Smashboard here, and after posting it to the Smashboard,
 * it pops up on the application on the laptop. Users can put values into and get values
 * from the Smashboard.
 *
 * @author Shivashriganesh Mahato
 */
public class Smashboard {

    private static final NetworkTable table = NetworkTable.getTable("smashboard");

    /**
     * Put a number in the table.
     *
     * @param key   the key to be assigned to
     * @param value the value that will be assigned
     * @return False if the table key already exists with a different type
     */
    public static boolean putNumber(String key, double value) {
        return table.putNumber(key, value);
    }

    /**
     * Returns the number the key maps to. If the key does not exist or is of
     * different type, it will return the default value.
     *
     * @param key          the key to look up
     * @param defaultValue the value to be returned if no value is found
     * @return the value associated with the given key or the given default value
     * if there is no value associated with the key
     */
    public static double getNumber(String key, double defaultValue) {
        return table.getNumber(key, defaultValue);
    }

    /**
     * Put a boolean in the table.
     *
     * @param key   the key to be assigned to
     * @param value the value that will be assigned
     * @return False if the table key already exists with a different type
     */
    public static boolean putBoolean(String key, boolean value) {
        return table.putBoolean(key, value);
    }

    /**
     * Returns the boolean the key maps to. If the key does not exist or is of
     * different type, it will return the default value.
     *
     * @param key          the key to look up
     * @param defaultValue the value to be returned if no value is found
     * @return the value associated with the given key or the given default value
     * if there is no value associated with the key
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        return table.getBoolean(key, defaultValue);
    }

    /**
     * Put a point in the table. This is done by putting 2 individual numbers with the same key as the prefix and
     * suffixing a X or Y to the end of it, depending on the value.
     *
     * @param key the key to be assigned to
     * @param x   the x value of the point that will be assigned
     * @param y   the y value of the point that will be assigned
     * @return False if the table key already exists with a different type
     */
    public static boolean putPoint(String key, double x, double y) {
        boolean xFlag = table.putNumber((key + "X"), x);
        boolean yFlag = table.putNumber((key + "Y"), y);
        return xFlag && yFlag;
    }

}
