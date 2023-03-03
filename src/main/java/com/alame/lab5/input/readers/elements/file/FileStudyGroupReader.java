package com.alame.lab5.input.readers.elements.file;

import com.alame.lab5.elements.*;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.FileReader;
import com.alame.lab5.utility.parsers.StudyGroupParser;
import com.alame.lab5.input.readers.elements.StudyGroupReader;

import java.io.IOException;

public class FileStudyGroupReader implements StudyGroupReader {
    private final FilePersonReader filePersonReader;
    private final FileReader fileReader;
    private final FileCoordinatesReader fileCoordinatesReader;
    public FileStudyGroupReader(FileReader fileReader) {
        this.fileReader = fileReader;
        filePersonReader = new FilePersonReader(fileReader);
        fileCoordinatesReader = new FileCoordinatesReader(fileReader);
    }

    @Override
    public StudyGroup readStudyGroup() throws IncorrectElementFieldException {
        return new StudyGroup(readName(), readCoordinates(), readStudentsCount(),
                readExpelledStudent(), readFormOfEducation(), readSemester(), readPerson());
    }

    @Override
    public String readName() throws IncorrectElementFieldException {
        try{
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return StudyGroupParser.parseName(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }

    @Override
    public Coordinates readCoordinates() throws IncorrectElementFieldException {
        return fileCoordinatesReader.readCoordinates();
    }

    @Override
    public Integer readStudentsCount() throws IncorrectElementFieldException {
        try{
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return StudyGroupParser.parseStudentsCount(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }

    @Override
    public Long readExpelledStudent() throws IncorrectElementFieldException {
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return StudyGroupParser.parseExpelledStudents(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }

    @Override
    public FormOfEducation readFormOfEducation() throws IncorrectElementFieldException {
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return StudyGroupParser.parseFormOfEducation(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }

    @Override
    public Semester readSemester() throws IncorrectElementFieldException {
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return StudyGroupParser.parseSemester(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }

    @Override
    public Person readPerson() throws IncorrectElementFieldException {
        return filePersonReader.readPerson();
    }

    @Override
    public StudyGroupReader clone() {
        try {
            return (StudyGroupReader) super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

}
