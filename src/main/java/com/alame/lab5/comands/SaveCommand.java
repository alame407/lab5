package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

import java.io.IOException;

public class SaveCommand implements Command{
    private final Printer printer = new ConsolePrinter();
    private final Receiver receiver;
    public SaveCommand(Receiver receiver){
        this.receiver = receiver;
    }
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

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }

    @Override
    public String description() {
        return "save: сохраняет коллекцию в файл";
    }

    @Override
    public String name() {
        return "save";
    }

    @Override
    public Command newInstance() {
        return new SaveCommand(receiver);
    }
}
