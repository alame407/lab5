package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class PrintFieldDescendingGroupAdminCommand implements Command{
    private final Receiver receiver;
    private final Printer printer = new ConsolePrinter();
    public PrintFieldDescendingGroupAdminCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public boolean execute() {
        receiver.printFieldDescendingGroupAdmin().forEach(printer::println);
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=0) throw new IncorrectCommandParameterException("Данная команда не принимает аргументов");
    }

    @Override
    public String description() {
        return "print_field_descending_group_admin: выводит значения поля groupAdmin всех элементов в порядке убывания";
    }

    @Override
    public String name() {
        return "print_field_descending_group_admin";
    }

    @Override
    public Command newInstance() {
        return new PrintFieldDescendingGroupAdminCommand(receiver);
    }
}
