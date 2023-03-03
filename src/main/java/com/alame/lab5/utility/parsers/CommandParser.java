package com.alame.lab5.utility.parsers;

import com.alame.lab5.App;
import com.alame.lab5.comands.Command;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.CommandNotFoundException;

import java.util.Arrays;

public class CommandParser {
    public static Command parseCommand(String line) throws CommandNotFoundException, IncorrectCommandParameterException{
        String[] arguments = line.split(" ");
        if (App.getCommandHandler().commandExist(arguments[0])){
            Command command = App.getCommandHandler().getNewCommandInstanceByString(arguments[0]);
            command.setParameters(Arrays.copyOfRange(arguments, 1, arguments.length));
            return command;
        }
        else{
            throw new CommandNotFoundException("Такой команды нет");
        }
    }
}
