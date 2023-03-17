package com.alame.lab5.comands;

import com.alame.lab5.executors.Executor;
import com.alame.lab5.utility.structers.LimitedQueue;

import java.util.*;

/**
 * class for processing commands and saving them to history
 */
public class CommandHandler {
    /**
     * size of the stored history of the command
     */
    private final static int HISTORY_SIZE = 12;
    /**
     * field that store history of last commands
     */
    private final Queue<String> history = new LimitedQueue<>(HISTORY_SIZE);
    /**
     * field that executes the command
     */
    private final Executor executor = new Executor();

    public CommandHandler(){}

    /**
     * handle given command
     * @param command - command to handle
     * @return success of command execution
     */
    public boolean handle(Command command){
        executor.setCommand(command);
        if(executor.executeCommand()){
            addCommandToHistory(command);
            return true;
        }
        return false;
    }

    /**
     * add given command to history
     * @param command - command to add
     */
    private void addCommandToHistory(Command command){
        history.add(command.name());
    }

    /**
     * @return history of last commands
     */
    public Queue<String> getHistory() {
        return history;
    }
}
