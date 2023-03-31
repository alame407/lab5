package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;

/**
 * command for removing keys from collection that less than given
 */
public class RemoveLowerKeyCommand implements Command{
    private final Receiver receiver;
    private String key;
    public RemoveLowerKeyCommand(Receiver receiver){
        this.receiver = receiver;
    }

    /**
     * remove all keys in collection that less than given
     * @return true
     */
    @Override
    public boolean execute() {
        receiver.removeLowerKey(key);
        return true;
    }

    /**
     * set key
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException if parameters size!=1
     */
    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Данная команда принимает 1 аргумент");
        this.key = parameters[0];
    }

    /**
     * @return command description
     */
    @Override
    public String description() {
        return "remove_lower_key key: удаляет из коллекции все элементы, ключ которых меньше, чем заданный";
    }

    /**
     * @return command name
     */
    @Override
    public String name() {
        return "remove_lower_key";
    }

    /**
     * create new RemoveLowerKeyCommand
     * @return new RemoveLowerKeyCommand with same receiver
     */
    @Override
    public Command newInstance() {
        return new RemoveLowerKeyCommand(receiver);
    }
}
