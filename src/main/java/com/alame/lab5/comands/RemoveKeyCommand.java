package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;

public class RemoveKeyCommand implements Command{
    private final Receiver receiver;
    private String key;
    public RemoveKeyCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        receiver.removeKey(key);
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Данная команда принимает 1 аргумент");
        this.key = parameters[0];
    }

    @Override
    public String description() {
        return "remove_key key: Удаляет элемент коллекции с заданным ключом";
    }

    @Override
    public String name() {
        return "remove_key";
    }

    @Override
    public Command newInstance() {
        return new RemoveKeyCommand(receiver);
    }
}
