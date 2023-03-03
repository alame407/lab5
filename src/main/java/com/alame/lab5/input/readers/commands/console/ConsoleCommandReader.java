package com.alame.lab5.input.readers.commands.console;

import com.alame.lab5.comands.Command;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.CommandNotFoundException;
import com.alame.lab5.input.readers.ConsoleReader;
import com.alame.lab5.utility.parsers.CommandParser;
import com.alame.lab5.input.readers.commands.CommandReader;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class ConsoleCommandReader extends ConsoleReader implements CommandReader {
    private final Printer printer = new ConsolePrinter();
    public Command readCommand(){
        printer.print("Введите команду ");
        while(true) {

            String nextLine = getNextLine();
            try {
                return CommandParser.parseCommand(nextLine).clone();
            } catch (CommandNotFoundException | IncorrectCommandParameterException e) {
                printer.print(e.getMessage() + ", повторите ввод снова ");
            }

        }
    }
}
