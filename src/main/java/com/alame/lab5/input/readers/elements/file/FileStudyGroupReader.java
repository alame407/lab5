package com.alame.lab5.input.readers.elements.file;

import com.alame.lab5.elements.*;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.FileReader;
import com.alame.lab5.utility.parsers.StudyGroupParser;
import com.alame.lab5.input.readers.elements.StudyGroupReader;

import java.io.IOException;

/**
 * class for reading studyGroup from file
 */
public class FileStudyGroupReader implements StudyGroupReader {
    /**
     * field that realise reading person
     */
    private final FilePersonReader filePersonReader;
    /**
     * field that realise reading from file
     */
    private final FileReader fileReader;
    /**
     * field that realise reading coordinates
     */
    private final FileCoordinatesReader fileCoordinatesReader;
    public FileStudyGroupReader(FileReader fileReader) {
        this.fileReader = fileReader;
        filePersonReader = new FilePersonReader(fileReader);
        fileCoordinatesReader = new FileCoordinatesReader(fileReader);
    }

    /**
     * read studyGroup from file
     * @return received studyGroup
     * @throws IncorrectElementFieldException if studyGroup is not valid
     */
    @Override
    public StudyGroup readStudyGroup() throws IncorrectElementFieldException {
        return new StudyGroup(readName(), readCoordinates(), readStudentsCount(),
                readExpelledStudent(), readFormOfEducation(), readSemester(), readPerson());
    }
    /**
     * read name from file
     * @return received name
     * @throws IncorrectElementFieldException if name is not valid
     */
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
    /**
     * read coordinates from file
     * @return received coordinates
     * @throws IncorrectElementFieldException if coordinates is not valid
     */
    @Override
    public Coordinates readCoordinates() throws IncorrectElementFieldException {
        return fileCoordinatesReader.readCoordinates();
    }
    /**
     * read studentsCount from file
     * @return received studentsCount
     * @throws IncorrectElementFieldException if studentsCount is not valid
     */
    @Override
    public int readStudentsCount() throws IncorrectElementFieldException {
        try{
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return StudyGroupParser.parseStudentsCount(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
    /**
     * read expelledStudents from file
     * @return received expelledStudents
     * @throws IncorrectElementFieldException if expelledStudents is not valid
     */
    @Override
    public long readExpelledStudent() throws IncorrectElementFieldException {
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return StudyGroupParser.parseExpelledStudents(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
    /**
     * read formOfEducation from file
     * @return received formOfEducation
     * @throws IncorrectElementFieldException if formOfEducation is not valid
     */
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
    /**
     * read semester from file
     * @return received semester
     * @throws IncorrectElementFieldException if semester is not valid
     */
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
    /**
     * read person from file
     * @return received person
     * @throws IncorrectElementFieldException if person is not valid
     */
    @Override
    public Person readPerson() throws IncorrectElementFieldException {
        return filePersonReader.readPerson();
    }


}
