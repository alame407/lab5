package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.CollectionIsEmptyException;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class MaxByCreationDateCommand extends AbstractCommand{
    private final Receiver receiver;
    private final Printer printer = new ConsolePrinter();
    public MaxByCreationDateCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public boolean execute() {
        try {
            printer.println(receiver.maxByCreationDate());
        }
        catch (CollectionIsEmptyException e){
            printer.println(e.getMessage());
        }
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }

    @Override
    public String description() {
        return "max_by_creation_date: выводит любой объект из коллекции, " +
                "значение поля creationDate которого является максимальным";
    }

    @Override
    public String name() {
        return "max_by_creation_date";
    }
}
