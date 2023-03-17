package com.alame.lab5.comands;

import com.alame.lab5.exceptions.IncorrectCommandParameterException;

public class ExitCommand implements Command{
    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }

    @Override
    public String description() {
        return "exit: завершает работу программы";
    }

    @Override
    public String name() {
        return "exit";
    }

    @Override
    public Command newInstance() {
        return new ExitCommand();
    }
}
