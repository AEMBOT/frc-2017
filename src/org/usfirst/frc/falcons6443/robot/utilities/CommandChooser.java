package org.usfirst.frc.falcons6443.robot.utilities;

import edu.wpi.first.wpilibj.command.Command;

import java.util.HashMap;

/**
 * The {@link CommandChooser} class is a useful tool for presenting a selection of options to the
 * {@link Smashboard}.
 * <p>
 * <p>For instance, you may wish to be able to select between multiple autonomous modes. You can do
 * this by putting every possible {@link Command} you want to run as an autonomous into a {@link
 * CommandChooser} and then put it into the {@link Smashboard} to have a list of options appear
 * on the driver station. Once autonomous starts, simply ask the {@link CommandChooser} what the selected
 * value is.
 *
 * @author Shivashriganesh Mahato
 */
public class CommandChooser {

    private String name;
    private String defaultOptionKey;
    private HashMap<String, Command> options;

    /**
     * Construct a new Command Chooser with a given name
     *
     * @param name The name of the chooser; this is drawn on the Smashboard
     */
    public CommandChooser(String name) {
        this.name = name;
        options = new HashMap<>();
        defaultOptionKey = "";
    }

    /**
     * Add the default command, the command that will be selected when the Smashboard starts up
     *
     * @param name    The name of the default command (shown in options list)
     * @param command The {@link Command} that will be returned as the selected value when this command is selected
     *                on the Smashboard
     */
    public void addDefault(String name, Command command) {
        if (name.equals(""))
            throw new IllegalArgumentException("Name of default option cannot be empty");
        if (containsOption(name))
            throw new IllegalArgumentException("Option with that name already exists");
        defaultOptionKey = name;
        options.put(name, command);
    }

    /**
     * Add an option to the command chooser
     * <p>
     * Precondition: Default command already set
     *
     * @param name    The name of the command (shown in the options list). Can't be used already in the default command or
     *                another option
     * @param command The {@link Command} that will be returned as the selected value when this command is selected
     *                on the Smashboard
     */
    public void addOption(String name, Command command) {
        if (defaultOptionKey.equals(""))
            throw new NullPointerException("Cannot add option when default option is undefined");
        if (containsOption(name))
            throw new IllegalArgumentException("Option with that name already exists");
        options.put(name, command);
    }

    /**
     * Check if the command chooser already contains an option with a specific name
     *
     * @param name The name of the command to search for in the options
     * @return Does the command chooser already contain an option with the specified name?
     */
    public boolean containsOption(String name) {
        for (String key : options.keySet())
            if (key.equals(name))
                return true;
        return false;
    }

    /**
     * Accessor for defaultOptionKey
     *
     * @return The key of the default command
     */
    public String getDefaultOptionKey() {
        return defaultOptionKey;
    }

    /**
     * Accessor for options
     *
     * @return The list of options
     */
    public HashMap<String, Command> getOptions() {
        return options;
    }

    /**
     * Accessor for name
     *
     * @return The name of the command chooser
     */
    public String getName() {
        return name;
    }
}
