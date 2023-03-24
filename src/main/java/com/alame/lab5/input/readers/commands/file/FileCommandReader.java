package com.alame.lab5.input.readers.commands.file;

import com.alame.lab5.comands.Command;
import com.alame.lab5.exceptions.CommandNotFoundException;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.input.readers.FileReader;
import com.alame.lab5.input.readers.commands.CommandReader;
import com.alame.lab5.utility.parsers.CommandParser;

import java.io.IOException;

/**
 * class for reading command from file
 */
public class FileCommandReader implements CommandReader {
    /**
     * field that realise reading from file
     */
    private final FileReader fileReader;
    public FileCommandReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    /**
     * read command from file
     * @return received command
     * @throws IncorrectCommandParameterException if command parameters are not valid or command doesn't exist
     */
    @Override
    public Command readCommand() throws IncorrectCommandParameterException{
        try{
            return CommandParser.parseCommand(fileReader.getNextLine());
        } catch (IOException | CommandNotFoundException e) {
            throw new IncorrectCommandParameterException(e.getMessage());
        }
    }
}
