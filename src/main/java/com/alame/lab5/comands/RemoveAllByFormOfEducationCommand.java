package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;

public class RemoveAllByFormOfEducationCommand extends AbstractCommand{
    private final Receiver receiver;
    public RemoveAllByFormOfEducationCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        try {
            receiver.removeAllByFormOfEducation(App.getUserInput().getStudyGroupReader().readFormOfEducation());
            return true;
        } catch (IncorrectElementFieldException e) {
            return false;
        }
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов, " +
                "поле formOfEducation вводится на следующей строке");
    }

    @Override
    public String description() {
        return "remove_all_by_form_of_education {formOfEducation}: удаляет из коллекции все элементы, " +
                "значение поля formOfEducation которого эквивалентно заданному";
    }

    @Override
    public String name() {
        return "remove_all_by_form_of_education";
    }
}
