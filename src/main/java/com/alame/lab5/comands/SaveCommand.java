package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

import java.io.IOException;

/**
 * command for saving collection
 */
public class SaveCommand implements Command{
    private final Printer printer = new ConsolePrinter();
    private final Receiver receiver;
    public SaveCommand(Receiver receiver){
        this.receiver = receiver;
    }

    /**
     * save collection
     * @return success of saving
     */
    @Override
    public boolean execute() {
        try {
            receiver.save();
            return true;
        }
        catch (IOException e){
            printer.println("не удалось сохранит коллекцию в файл");
            return false;
        }
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
        return "save: сохраняет коллекцию в файл";
    }

    /**
     * @return command name
     */
    @Override
    public String name() {
        return "save";
    }

    /**
     * create new SaveCommand
     * @return new SaveCommand with same receiver
     */
    @Override
    public Command newInstance() {
        return new SaveCommand(receiver);
    }
}
