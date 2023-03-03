package com.alame.lab5.input.readers.commands;

import com.alame.lab5.comands.Command;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;

public interface CommandReader {
    Command readCommand() throws IncorrectCommandParameterException;
}
