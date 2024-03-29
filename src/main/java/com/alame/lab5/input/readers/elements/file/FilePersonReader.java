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

/**
 * class for reading person file
 */
public class FilePersonReader {
    /**
     * field that realise reading from file
     */
    private final FileReader fileReader;
    public FilePersonReader(FileReader fileReader){
        this.fileReader = fileReader;
    }

    /**
     * read person from file
     * @return received person
     * @throws IncorrectElementFieldException if person is not valid
     */
    public Person readPerson() throws IncorrectElementFieldException{
        return new Person(readName(),readBirthday() , readEyesColor(), readHairColor(), readNationality());
    }

    /**
     * read name from file
     * @return received name
     * @throws IncorrectElementFieldException if name is not valid
     */
    public String readName() throws IncorrectElementFieldException {
        try{
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return PersonParser.parseName(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }

    /**
     * read birthday from file
     * @return received birthday
     * @throws IncorrectElementFieldException if birthday is not valid
     */
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
    /**
     * read eyesColor from file
     * @return received eyesColor
     * @throws IncorrectElementFieldException if eyesColor is not valid
     */
    public EyesColor readEyesColor() throws IncorrectElementFieldException{
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return PersonParser.parseEyesColor(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
    /**
     * read haiColor from file
     * @return received hairColor
     * @throws IncorrectElementFieldException if hairColor is not valid
     */
    public HairColor readHairColor() throws IncorrectElementFieldException{
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return PersonParser.parseHairColor(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
    /**
     * read nationality from file
     * @return received nationality
     * @throws IncorrectElementFieldException if nationality is not valid
     */
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
