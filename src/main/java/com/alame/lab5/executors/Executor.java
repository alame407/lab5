package com.alame.lab5.executors;

import com.alame.lab5.comands.Command;

public class Executor {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public boolean executeCommand(){
        return command.execute();
    }
}
