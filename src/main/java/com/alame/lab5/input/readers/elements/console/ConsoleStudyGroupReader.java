package com.alame.lab5.input.readers.elements.console;

import com.alame.lab5.elements.*;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.ConsoleReader;
import com.alame.lab5.input.readers.elements.StudyGroupReader;
import com.alame.lab5.utility.parsers.StudyGroupParser;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class ConsoleStudyGroupReader extends ConsoleReader implements StudyGroupReader {
    private final ConsoleCoordinatesReader consoleCoordinatesReader = new ConsoleCoordinatesReader();
    private final ConsolePersonReader consolePersonReader = new ConsolePersonReader();
    private final Printer printer = new ConsolePrinter();
    @Override
    public StudyGroup readStudyGroup() {
        return new StudyGroup(readName(), readCoordinates(), readStudentsCount(),
                readExpelledStudent(), readFormOfEducation(), readSemester(), readPerson());
    }
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
    @Override
    public Coordinates readCoordinates(){
        return consoleCoordinatesReader.readCoordinates();
    }
    @Override
    public Integer readStudentsCount(){
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
    @Override
    public Long readExpelledStudent(){
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
    @Override
    public Person readPerson(){
        return consolePersonReader.readPerson();
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
