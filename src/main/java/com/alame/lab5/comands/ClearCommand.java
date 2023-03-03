package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;

public class ClearCommand extends AbstractCommand {
    private final Receiver receiver;
    public ClearCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        receiver.clear();
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
    }

    @Override
    public String description() {
        return "clear: очищает коллекцию";
    }

    @Override
    public String name() {
        return "clear";
    }

}
