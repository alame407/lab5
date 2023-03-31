package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.UserInput;

/**
 * class for replacing element by key if element greater than given
 */
public class ReplaceIfLowerCommand implements Command{
    private  String key;
    private final Receiver receiver;
    private final UserInput userInput;
    public ReplaceIfLowerCommand(Receiver receiver, UserInput userInput){
        this.receiver = receiver;
        this.userInput = userInput;
    }

    /**
     * replace value in collection by key if new value less than old
     * @return true if reading was successful else false
     */
    @Override
    public boolean execute() {
        try {
            receiver.replaceIfLower(key, userInput.getStudyGroupReader().readStudyGroup());
            return true;
        }
        catch(IncorrectElementFieldException e){
            return false;
        }
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
        return "replace_if_lower key {element}: заменяет значение по ключу, если новое значение меньше старого";
    }

    /**
     * @return command name
     */
    @Override
    public String name() {
        return "replace_if_lower";
    }

    /**
     * create new ReplaceIfLowerCommand
     * @return new ReplaceIfLowerCommand with same receiver and userInput
     */
    @Override
    public Command newInstance() {
        return new ReplaceIfLowerCommand(receiver, userInput);
    }

}
