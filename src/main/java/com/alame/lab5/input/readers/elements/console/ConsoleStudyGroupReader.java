package com.alame.lab5.input.readers.elements.console;

import com.alame.lab5.elements.*;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.ConsoleReader;
import com.alame.lab5.input.readers.elements.StudyGroupReader;
import com.alame.lab5.utility.parsers.StudyGroupParser;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

/**
 * class for reading StudyGroup from console
 */
public class ConsoleStudyGroupReader extends ConsoleReader implements StudyGroupReader {
    /**
     * field that realise reading coordinates
     */
    private final ConsoleCoordinatesReader consoleCoordinatesReader = new ConsoleCoordinatesReader();
    /**
     * field that realise reading person
     */
    private final ConsolePersonReader consolePersonReader = new ConsolePersonReader();
    private final Printer printer = new ConsolePrinter();

    /**
     * read studyGroup from console
     * @return received studyGroup
     */
    @Override
    public StudyGroup readStudyGroup() {
        return new StudyGroup(readName(), readCoordinates(), readStudentsCount(),
                readExpelledStudent(), readFormOfEducation(), readSemester(), readPerson());
    }

    /**
     * read name from console
     * @return received name
     */
    @Override
    public String readName(){
        printer.print("Введите имя группы ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try{
                return StudyGroupParser.parseName(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }

    /**
     * read coordinates from console
     * @return received coordinates
     */
    @Override
    public Coordinates readCoordinates(){
        return consoleCoordinatesReader.readCoordinates();
    }

    /**
     * read studentsCount from console
     * @return received studentsCount
     */
    @Override
    public int readStudentsCount(){
        printer.print("Введите количество студентов ");
        while (true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try{
                return StudyGroupParser.parseStudentsCount(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }

    /**
     * read expelledStudents from console
     * @return received expelledStudents
     */
    @Override
    public long readExpelledStudent(){
        printer.print("Введите количество отчисленных студентов ");
        while (true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try {
                return StudyGroupParser.parseExpelledStudents(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.println(e.getMessage() + ", повторите ввод ");
            }
        }
    }

    /**
     * read formOfEducation from console
     * @return received formOfEducation
     */
    @Override
    public FormOfEducation readFormOfEducation(){
        printer.print("введите форму обучения, возможные варианты " + FormOfEducation.possibleValues() + " ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try {
                return StudyGroupParser.parseFormOfEducation(nextLine);
            }
            catch(IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }

    /**
     * read semester from console
     * @return received semester
     */
    @Override
    public Semester readSemester(){
        printer.print("Введите семестр, возможные варианты " + Semester.possibleValues() + " ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try {
                return StudyGroupParser.parseSemester(nextLine);
            }
            catch(IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }

    /**
     * read person from console
     * @return received person
     */
    @Override
    public Person readPerson(){
        return consolePersonReader.readPerson();
    }
}
