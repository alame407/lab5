package com.alame.lab5.executors;

import com.alame.lab5.comands.Command;

/**
 * class for command execution
 */
public class Executor {
    /**
     * current command
     */
    private Command command;

    /**
     * set current command
     * @param command - current command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * execute current command
     * @return success of command execution
     */
    public boolean executeCommand(){
        return command.execute();
    }
}
