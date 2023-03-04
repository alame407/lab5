package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class HistoryCommand extends AbstractCommand{
    private final Printer printer = new ConsolePrinter();
    @Override
    public boolean execute() {
        printer.println(App.getCommandHandler().getHistory());
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
}
