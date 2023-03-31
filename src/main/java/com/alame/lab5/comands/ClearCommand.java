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

    /**
     * clear collection
     * @return true
     */
    @Override
    public boolean execute(){
        receiver.clear();
        return true;
    }

    /**
     * set no parameters
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException if parameters size!=0
     */
    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }

    /**
     * @return command description
     */
    @Override
    public String description() {
        return "clear: очищает коллекцию";
    }

    /**
     * @return command name
     */
    @Override
    public String name() {
        return "clear";
    }

    /**
     * create new Instance of ClearCommand
     * @return new ClearCommand with same receiver
     */
    @Override
    public Command newInstance() {
        return new ClearCommand(receiver);
    }

}
