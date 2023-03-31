package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

/**
 * command for showing all elements in collection
 */
public class ShowCommand implements Command{
    private final Receiver receiver;
    private final Printer printer = new ConsolePrinter();
    public ShowCommand(Receiver receiver){
        this.receiver = receiver;
    }

    /**
     * show all elements in collection
     * @return true
     */
    @Override
    public boolean execute() {
        receiver.show().forEach(printer::println);
        return true;
    }

    /**
     * set no parameters
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException if parameters size!=0
     */
    @Override
    public void setParameters(String[] parameters)  throws IncorrectCommandParameterException{
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }

    /**
     * @return command description
     */
    @Override
    public String description() {
        return "show: выводит элементы коллекции в строковом представлении";
    }

    /**
     * @return command name
     */
    @Override
    public String name() {
        return "show";
    }

    /**
     * create new ShowCommand
     * @return new ShowCommand with same receiver
     */
    @Override
    public Command newInstance() {
        return new ShowCommand(receiver);
    }
}
