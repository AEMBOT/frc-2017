package org.usfirst.frc.falcons6443.robot.utilities;

import edu.wpi.first.wpilibj.command.Command;

import java.util.HashMap;

/**
 * @author Shivashriganesh Mahato
 */
public class CommandChooser {

    private String name;
    private String defaultOptionKey;
    private HashMap<String, Command> options;

    public CommandChooser(String name) {
        this.name = name;
        options = new HashMap<>();
        defaultOptionKey = "";
    }

    public void addDefault(String name, Command command) {
        if (name.equals(""))
            throw new IllegalArgumentException("Name of default option cannot be empty");
        if (containsOption(name))
            throw new IllegalArgumentException("Option with that name already exists");
        defaultOptionKey = name;
        options.put(name, command);
    }

    public void addOption(String name, Command command) {
        if (defaultOptionKey.equals(""))
            throw new NullPointerException("Cannot add option when default option is undefined");
        if (containsOption(name))
            throw new IllegalArgumentException("Option with that name already exists");
        options.put(name, command);
    }

    public boolean containsOption(String name) {
        for (String key : options.keySet())
            if (key.equals(name))
                return true;
        return false;
    }

    public String getDefaultOptionKey() {
        return defaultOptionKey;
    }

    public HashMap<String, Command> getOptions() {
        return options;
    }

    public String getName() {
        return name;
    }
}
