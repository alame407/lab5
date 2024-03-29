package com.alame.lab5.utility.parsers;

import com.alame.lab5.App;
import com.alame.lab5.comands.Command;
import com.alame.lab5.comands.CommandMapper;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.CommandNotFoundException;

import java.util.Arrays;

/**
 * class for parsing command from string
 */
public class CommandParser {
    /**
     * parse command from string
     * @param line string to parse
     * @return command
     * @throws CommandNotFoundException if command doesn't exist
     * @throws IncorrectCommandParameterException if command parameters are not valid
     */
    public static Command parseCommand(String line) throws CommandNotFoundException, IncorrectCommandParameterException{
        String[] arguments = line.split(" ");
        if (CommandMapper.getInstance().commandExist(arguments[0])){
            Command command = CommandMapper.getInstance().getNewCommandInstanceByString(arguments[0]);
            command.setParameters(Arrays.copyOfRange(arguments, 1, arguments.length));
            return command;
        }
        else{
            throw new CommandNotFoundException("Такой команды нет");
        }
    }
}
