package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.elements.StudyGroup;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class ShowCommand extends AbstractCommand{
    private final Receiver receiver;
    private final Printer printer = new ConsolePrinter();
    public ShowCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        receiver.show().forEach(printer::println);
        return true;
    }

    @Override
    public void setParameters(String[] parameters)  throws IncorrectCommandParameterException{
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
    }

    @Override
    public String description() {
        return "show: выводит элементы коллекции в строковом представлении";
    }

    @Override
    public String name() {
        return "show";
    }
}
