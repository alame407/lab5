package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;

/**
 * Command for clear collection
 */

public class ClearCommand implements Command{
    /**
     * field that realize collection clear
     */
    private final Receiver receiver;
    public ClearCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute(){
        receiver.clear();
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }

    @Override
    public String description() {
        return "clear: очищает коллекцию";
    }

    @Override
    public String name() {
        return "clear";
    }

    @Override
    public Command newInstance() {
        return new ClearCommand(receiver);
    }

}
