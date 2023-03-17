package com.alame.lab5.comands;

import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class HistoryCommand implements Command{
    private final Printer printer = new ConsolePrinter();
    private final CommandHandler commandHandler;
    public HistoryCommand(CommandHandler commandHandler){
        this.commandHandler = commandHandler;
    }
    @Override
    public boolean execute() {
        printer.println(commandHandler.getHistory());
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }

    @Override
    public String description() {
        return "history: выводит 15 последних команд";
    }

    @Override
    public String name() {
        return "history";
    }

    @Override
    public Command newInstance() {
        return new HistoryCommand(commandHandler);
    }
}
