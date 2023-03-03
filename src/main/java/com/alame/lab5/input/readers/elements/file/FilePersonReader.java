package com.alame.lab5.input.readers.elements.file;

import com.alame.lab5.elements.Country;
import com.alame.lab5.elements.EyesColor;
import com.alame.lab5.elements.HairColor;
import com.alame.lab5.elements.Person;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.FileReader;
import com.alame.lab5.utility.parsers.PersonParser;

import java.io.IOException;
import java.time.LocalDate;

public class FilePersonReader {
    private final FileReader fileReader;
    public FilePersonReader(FileReader fileReader){
        this.fileReader = fileReader;
    }
    public Person readPerson() throws IncorrectElementFieldException{
        return new Person(readName(),readBirthday() , readEyesColor(), readHairColor(), readNationality());
    }
    public String readName() throws IncorrectElementFieldException {
        try{
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return PersonParser.parseName(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
    public LocalDate readBirthday() throws IncorrectElementFieldException{
        try{
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return PersonParser.parseBirthday(nextLine);
        }
        catch (IOException e){
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
    public EyesColor readEyesColor() throws IncorrectElementFieldException{
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return PersonParser.parseEyesColor(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
    public HairColor readHairColor() throws IncorrectElementFieldException{
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return PersonParser.parseHairColor(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
    public Country readNationality() throws IncorrectElementFieldException{
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return PersonParser.parseCountry(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
}
