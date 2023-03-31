package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

/**
 * command for show info about collection
 */
public class InfoCommand implements Command{
    private final Printer printer = new ConsolePrinter();
    private final Receiver receiver;
    public InfoCommand(Receiver receiver){
        this.receiver = receiver;
    }

    /**
     * show information about collection
     * @return true
     */
    @Override
    public boolean execute() {
        printer.println(receiver.info());
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
        return "info: выводит информацию о коллекции";
    }
    /**
     * @return command name
     */
    @Override
    public String name() {
        return "info";
    }

    /**
     * create new IndoCommand
     * @return new InfoCommand with same receiver
     */
    @Override
    public Command newInstance() {
        return new InfoCommand(receiver);
    }
}
