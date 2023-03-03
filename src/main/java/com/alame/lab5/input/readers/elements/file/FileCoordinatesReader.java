package com.alame.lab5.input.readers.elements.file;

import com.alame.lab5.elements.Coordinates;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.FileReader;
import com.alame.lab5.utility.parsers.CoordinatesParser;

import java.io.IOException;

public class FileCoordinatesReader {
    private final FileReader fileReader;
    public FileCoordinatesReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }
    public Coordinates readCoordinates() throws IncorrectElementFieldException {
        return new Coordinates(readX(), readY());
    }
    public Long readX() throws IncorrectElementFieldException{
        try{
            String nextLine = fileReader.getNextLine();
            if(nextLine.equals("")) nextLine = null;
            return CoordinatesParser.parseX(nextLine);
        } catch (IOException e) {
            throw new IncorrectElementFieldException(e.getMessage());
        }

    }
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
