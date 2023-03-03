package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;

public class ReplaceIfLowerCommand extends AbstractCommand{
    private  String key;
    private final Receiver receiver;
    public ReplaceIfLowerCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        try {
            receiver.replaceIfLower(key, App.getUserInput().readStudyGroup());
            return true;
        }
        catch(IncorrectElementFieldException e){
            return false;
        }
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
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
