package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;

public class RemoveLowerKeyCommand extends AbstractCommand{
    private final Receiver receiver;
    private String key;
    public RemoveLowerKeyCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        receiver.removeLowerKey(key);
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
        this.key = parameters[0];
    }

    @Override
    public String description() {
        return "remove_lower_key key: удаляет из коллекции все элементы, ключ которых меньше, чем заданный";
    }

    @Override
    public String name() {
        return "remove_lower_key";
    }
}
