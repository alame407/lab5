package com.alame.lab5.input.readers.elements.console;

import com.alame.lab5.elements.Country;
import com.alame.lab5.elements.EyesColor;
import com.alame.lab5.elements.HairColor;
import com.alame.lab5.elements.Person;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.ConsoleReader;
import com.alame.lab5.utility.parsers.PersonParser;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

import java.time.LocalDate;

public class ConsolePersonReader extends ConsoleReader {
    private final Printer printer = new ConsolePrinter();
    public Person readPerson(){
        return new Person(readName(), readBirthday(), readEyesColor(), readHairColor(), readNationality());
    }
    public String readName(){
        printer.print("Введите имя админа ");
        while (true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try{
                return PersonParser.parseName(nextLine);
            }
            catch(IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }
    public LocalDate readBirthday(){
        printer.print("Введите день рождения админа ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try {
                return PersonParser.parseBirthday(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }
    public EyesColor readEyesColor(){
        printer.print("Введите цвет глаз админа возможные варианты " + EyesColor.possibleValues() + " ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try {
                return PersonParser.parseEyesColor(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }
    public HairColor readHairColor(){
        printer.print("Введите цвет волос админа возможные варианты " + HairColor.possibleValues() + " ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try {
                return PersonParser.parseHairColor(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }
    public Country readNationality(){
        printer.print("Введите национальность админа возможные варианты " + Country.possibleValues() + " ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try {
                return PersonParser.parseCountry(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }
}
