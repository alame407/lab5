package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.elements.StudyGroup;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.UserInput;
import com.alame.lab5.input.readers.elements.StudyGroupReader;

public class UpdateCommand extends AbstractCommand{
    private int id;
    private final Receiver receiver;
    public UpdateCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        try{
            StudyGroupReader studyGroupReader = App.getUserInput().getStudyGroupReader();
            receiver.update(id, studyGroupReader.readName(), studyGroupReader.readCoordinates(),
                    studyGroupReader.readStudentsCount(), studyGroupReader.readExpelledStudent(),
                    studyGroupReader.readFormOfEducation(), studyGroupReader.readSemester(),
                    studyGroupReader.readPerson());
            return true;
        }
        catch(IncorrectElementFieldException e){
            return false;
        }
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Данная команда принимает 1 аргумент");
        else{
            try{
                id = Integer.parseInt(parameters[0]);
                if (!receiver.idExist(id)) throw new IncorrectCommandParameterException("Такого id не существует");
            }
            catch(NumberFormatException e){
                throw new IncorrectCommandParameterException("Аргумент команды должен быть целым числом");
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
