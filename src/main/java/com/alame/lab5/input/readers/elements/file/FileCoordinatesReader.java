package com.alame.lab5.input.readers.elements.file;

import com.alame.lab5.elements.Coordinates;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.FileReader;
import com.alame.lab5.utility.parsers.CoordinatesParser;

import java.io.IOException;

/**
 * class for reading coordinates from file
 */
public class FileCoordinatesReader {
    /**
     * field that realise reading from file
     */
    private final FileReader fileReader;
    public FileCoordinatesReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    /**
     * read coordinates from file
     * @return received coordinates
     * @throws IncorrectElementFieldException if coordinates is not valid
     */
    public Coordinates readCoordinates() throws IncorrectElementFieldException {
        return new Coordinates(readX(), readY());
    }

    /**
     * read x from file
     * @return received x
     * @throws IncorrectElementFieldException if x is not valid
     */
    public Long readX() throws IncorrectElementFieldException{
        try{
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return CoordinatesParser.parseX(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }

    }

    /**
     * read y from file
     * @return received y
     * @throws IncorrectElementFieldException if y is not valid
     */
    public float readY() throws IncorrectElementFieldException{
        try {
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return CoordinatesParser.parseY(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }
    }
}
