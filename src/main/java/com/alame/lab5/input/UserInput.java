package com.alame.lab5.input;

import com.alame.lab5.comands.Command;
import com.alame.lab5.elements.StudyGroup;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.commands.CommandReader;
import com.alame.lab5.input.readers.elements.StudyGroupReader;

public class UserInput {
    private StudyGroupReader studyGroupReader;
    private CommandReader commandReader;
    public UserInput(CommandReader commandReader, StudyGroupReader studyGroupReader){
        this.commandReader = commandReader;
        this.studyGroupReader = studyGroupReader;
    }

    public void setCommandReader(CommandReader commandReader) {
        this.commandReader = commandReader;
    }

    public void setStudyGroupReader(StudyGroupReader studyGroupReader) {
        this.studyGroupReader = studyGroupReader;
    }
    public StudyGroup readStudyGroup() throws IncorrectElementFieldException {
        return studyGroupReader.readStudyGroup();
    }

    public CommandReader getCommandReader() {
        return commandReader;
    }

    public StudyGroupReader getStudyGroupReader() {
        return studyGroupReader;
    }

    public Command readCommand() throws IncorrectCommandParameterException {
        return commandReader.readCommand();
    }
}
