package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class HelpCommand extends AbstractCommand{
    private final Printer printer = new ConsolePrinter();
    public HelpCommand(){
    }
    @Override
    public boolean execute() {
        for(Command command: App.getCommandHandler().getAllCommands()){
            printer.println(command.description());
        }
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
    }

    @Override
    public String description() {
        return "help: выводит справку о командах";
    }

    @Override
    public String name() {
        return "help";
    }
}
