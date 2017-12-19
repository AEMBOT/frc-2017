//package org.usfirst.frc.falcons6443.robot.commands;

/**
 * Command to toggle the gear holder to close when it's open and to open when it's closed.
 *
 * @author Christopher Medlin
 */
/*public class ToggleGearHolder extends SimpleCommand {
    private boolean startState;

    public ToggleGearHolder() {
        super("Toggle Gear Holder");
        requires(gearHolder);
        System.out.println("Fired Command: ToggleGearHolder");
    }

    public void initialize() {
        startState = gearHolder.isOpen();
    }

    public void execute() {
        if (!startState) {
            gearHolder.open();
        } else {
            gearHolder.close();
        }
    }

    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.command.Command#isFinished()
     */
    /*@Override
    protected boolean isFinished() {
        return (gearHolder.isOpen() != startState);
    }

}*/
