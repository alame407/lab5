package com.alame.lab5.comands;

/**
 * Parent Class for all command that implements basic behavior clone
 */
public abstract class AbstractCommand implements Command{
    /**
     * Creates and returns a copy of this command
     * @return New command instance
     */
    @Override
    public Command clone() {
        try {
            return (Command) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getCause());
        }
    }
}
