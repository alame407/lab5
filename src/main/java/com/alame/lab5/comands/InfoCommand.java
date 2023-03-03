package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class InfoCommand extends AbstractCommand{
    private final Printer printer = new ConsolePrinter();
    private final Receiver receiver;
    public InfoCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        printer.println(receiver.info());
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
    }

    @Override
    public String description() {
        return "info: выводит информацию о коллекции";
    }

    @Override
    public String name() {
        return "info";
    }
}
