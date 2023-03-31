package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.CollectionIsEmptyException;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

/**
 * command for showing max element by creation date
 */
public class MaxByCreationDateCommand implements Command{
    private final Receiver receiver;
    private final Printer printer = new ConsolePrinter();
    public MaxByCreationDateCommand(Receiver receiver){
        this.receiver = receiver;
    }

    /**
     * show element of collection with max creation date
     * @return true
     */
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

    /**
     * set no parameters
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException
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
        return "max_by_creation_date: выводит любой объект из коллекции, " +
                "значение поля creationDate которого является максимальным";
    }
    /**
     * @return command name
     */
    @Override
    public String name() {
        return "max_by_creation_date";
    }

    /**
     * create new MaxByCreationDateCommand
     * @return new MaxByCreationDateCommand with same receiver
     */
    @Override
    public Command newInstance() {
        return new MaxByCreationDateCommand(receiver);
    }
}
