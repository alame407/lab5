package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;

/**
 * command for removing key from collection
 */
public class RemoveKeyCommand implements Command{
    private final Receiver receiver;
    private String key;
    public RemoveKeyCommand(Receiver receiver){
        this.receiver = receiver;
    }

    /**
     * remove key from collection
     * @return true
     */
    @Override
    public boolean execute() {
        receiver.removeKey(key);
        return true;
    }

    /**
     * set key
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException if parameters size!=1 or key doesn't exist
     */
    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Данная команда принимает 1 аргумент");
        if (!receiver.keyExist(parameters[0])) throw new IncorrectCommandParameterException("Такого ключа не существует");
        this.key = parameters[0];
    }

    /**
     * @return command description
     */
    @Override
    public String description() {
        return "remove_key key: Удаляет элемент коллекции с заданным ключом";
    }

    /**
     * @return command name
     */
    @Override
    public String name() {
        return "remove_key";
    }

    /**
     * create new RemoveKeyCommand
     * @return new RemoveKeyCommand with same receiver
     */
    @Override
    public Command newInstance() {
        return new RemoveKeyCommand(receiver);
    }
}
