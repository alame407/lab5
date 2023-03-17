package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.UserInput;

public class RemoveAllByFormOfEducationCommand implements Command{
    private final Receiver receiver;
    private final UserInput userInput;
    public RemoveAllByFormOfEducationCommand(Receiver receiver, UserInput userInput){
        this.receiver = receiver;
        this.userInput = userInput;
    }
    @Override
    public boolean execute() {
        try {
            receiver.removeAllByFormOfEducation(userInput.getStudyGroupReader().readFormOfEducation());
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

    @Override
    public Command newInstance() {
        return new RemoveAllByFormOfEducationCommand(receiver, userInput);
    }
}
