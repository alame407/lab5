package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.executors.Executor;
import com.alame.lab5.input.UserInput;
import com.alame.lab5.utility.structers.LimitedQueue;

import java.util.*;

public class CommandHandler {
    private final static int HISTORY_SIZE = 12;
    private final Queue<String> history = new LimitedQueue<>(HISTORY_SIZE);
    private final Executor executor = new Executor();

    public CommandHandler(){}

    public boolean handle(Command command){
        executor.setCommand(command);
        if(executor.executeCommand()){
            addCommandToHistory(command);
            return true;
        }
        return false;
    }
    private void addCommandToHistory(Command command){
        history.add(command.name());
    }

    public Queue<String> getHistory() {
        return history;
    }
}
