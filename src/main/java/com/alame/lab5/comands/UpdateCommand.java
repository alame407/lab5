package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.elements.StudyGroup;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;

public class UpdateCommand extends AbstractCommand{
    private int id;
    private final Receiver receiver;
    public UpdateCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        try{
            StudyGroup newStudyGroup = App.getUserInput().readStudyGroup();
            receiver.update(id, newStudyGroup);
            return true;
        }
        catch(IncorrectElementFieldException e){
            return false;
        }
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
        else{
            try{
                id = Integer.parseInt(parameters[0]);
            }
            catch(NumberFormatException e){
                throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
            }
        }
    }

    @Override
    public String description() {
        return "update id: обновляет значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String name() {
        return "update";
    }
}
