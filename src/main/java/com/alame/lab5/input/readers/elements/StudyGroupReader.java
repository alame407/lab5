package com.alame.lab5.input.readers.elements;

import com.alame.lab5.elements.*;
import com.alame.lab5.exceptions.IncorrectElementFieldException;

public interface StudyGroupReader {
    StudyGroup readStudyGroup() throws IncorrectElementFieldException;

    String readName() throws IncorrectElementFieldException;

    Coordinates readCoordinates() throws IncorrectElementFieldException;

    int readStudentsCount() throws IncorrectElementFieldException;

    long readExpelledStudent() throws IncorrectElementFieldException;

    FormOfEducation readFormOfEducation() throws IncorrectElementFieldException;

    Semester readSemester() throws IncorrectElementFieldException;

    Person readPerson() throws IncorrectElementFieldException;

}
