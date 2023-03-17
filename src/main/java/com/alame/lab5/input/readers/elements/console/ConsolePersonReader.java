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

/**
 * class for reading person from console
 */
public class ConsolePersonReader extends ConsoleReader {
    private final Printer printer = new ConsolePrinter();

    /**
     * read person from console
     * @return received person
     */
    public Person readPerson(){
        return new Person(readName(), readBirthday(), readEyesColor(), readHairColor(), readNationality());
    }

    /**
     * read name from console
     * @return received name
     */
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

    /**
     * read birthday from console
     * @return received birthday
     */
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

    /**
     * read eyesColor from console
     * @return received eyesColor
     */
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

    /**
     * read hairColor from console
     * @return received hairColor
     */
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

    /**
     * read nationality from console
     * @return received nationality
     */
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
