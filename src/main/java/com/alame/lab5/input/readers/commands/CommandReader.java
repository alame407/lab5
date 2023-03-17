package com.alame.lab5.input.readers.commands;

import com.alame.lab5.comands.Command;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;

/**
 * interface for all class that read commands
 */
public interface CommandReader {
    /**
     * read command
     * @return received command
     * @throws IncorrectCommandParameterException if command parametrs are not valid
     */
    Command readCommand() throws IncorrectCommandParameterException;
}
