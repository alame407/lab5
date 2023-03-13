package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.UserInput;

public class InsertCommand extends AbstractCommand{
    private final Receiver receiver;
    private final UserInput userInput;
    private String key;
    public InsertCommand(Receiver receiver, UserInput userInput){
        this.receiver = receiver;
        this.userInput = userInput;
    }
    @Override
    public boolean execute(){
        try {
            receiver.insert(key, userInput.readStudyGroup());
            return true;
        }
        catch (IncorrectElementFieldException e){
            return false;
        }
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Данная команда принимает 1 аргумент");
        else{
            key = parameters[0];
        }
    }

    @Override
    public String description() {
        return "insert key: добавляет новый элемент с заданным ключом";
    }

    @Override
    public String name() {
        return "insert";
    }
}
