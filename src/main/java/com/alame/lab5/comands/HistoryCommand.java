package com.alame.lab5.comands;

import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

/**
 * command for showing last names of commands
 */
public class HistoryCommand implements Command{
    private final Printer printer = new ConsolePrinter();
    private final CommandHandler commandHandler;
    public HistoryCommand(CommandHandler commandHandler){
        this.commandHandler = commandHandler;
    }

    /**
     * show name of last commands
     * @return true
     */
    @Override
    public boolean execute() {
        printer.println(commandHandler.getHistory());
        return true;
    }

    /**
     * set no parameters
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException if parameters size!=0
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
        return "history: выводит 15 последних команд";
    }
    /**
     * @return command name
     */
    @Override
    public String name() {
        return "history";
    }

    /**
     * create new HistoryCommand
     * @return new HistoryCommand with same commandHandler
     */
    @Override
    public Command newInstance() {
        return new HistoryCommand(commandHandler);
    }
}
