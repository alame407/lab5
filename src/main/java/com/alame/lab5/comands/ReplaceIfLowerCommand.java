package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.UserInput;

public class ReplaceIfLowerCommand extends AbstractCommand{
    private  String key;
    private final Receiver receiver;
    private final UserInput userInput;
    public ReplaceIfLowerCommand(Receiver receiver, UserInput userInput){
        this.receiver = receiver;
        this.userInput = userInput;
    }
    @Override
    public boolean execute() {
        try {
            receiver.replaceIfLower(key, userInput.readStudyGroup());
            return true;
        }
        catch(IncorrectElementFieldException e){
            return false;
        }
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Данная команда принимает 1 аргумент");
        this.key = parameters[0];
    }

    @Override
    public String description() {
        return "replace_if_lower key {element}: заменяет значение по ключу, если новое значение меньше старого";
    }

    @Override
    public String name() {
        return "replace_if_lower";
    }

}
