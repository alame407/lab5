package com.alame.lab5.comands;

import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

/**
 * command for showing all commands and their descriptions
 */
public class HelpCommand implements Command{
    private final Printer printer = new ConsolePrinter();
    public HelpCommand(){}

    /**
     * show all command and their descriptions
     * @return true
     */
    @Override
    public boolean execute() {
        for(Command command: CommandMapper.getInstance().getAllCommands()){
            printer.println(command.description());
        }
        return true;
    }

    /**
     * set no parameters
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException if parameter size!=0
     */
    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }
    /**
     * @return command description
     */
    @Override
    public String description() {
        return "help: выводит справку о командах";
    }
    /**
     * @return command name
     */
    @Override
    public String name() {
        return "help";
    }

    /**
     * create new HelpCommand
     * @return new HelpCommand
     */
    @Override
    public Command newInstance() {
        return new HelpCommand();
    }
}
