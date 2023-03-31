package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

/**
 * command for showing all groupAdmins in revers order
 */
public class PrintFieldDescendingGroupAdminCommand implements Command{
    private final Receiver receiver;
    private final Printer printer = new ConsolePrinter();
    public PrintFieldDescendingGroupAdminCommand(Receiver receiver){
        this.receiver = receiver;
    }

    /**
     * show all groupAdmins in reverse order
     * @return true
     */
    @Override
    public boolean execute() {
        receiver.printFieldDescendingGroupAdmin().forEach(printer::println);
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
        return "print_field_descending_group_admin: выводит значения поля groupAdmin всех элементов в порядке убывания";
    }
    /**
     * @return command name
     */
    @Override
    public String name() {
        return "print_field_descending_group_admin";
    }

    /**
     * create new PrintFieldDescendingGroupAdminCommand
     * @return new PrintFieldDescendingGroupAdminCommand with same receiver
     */
    @Override
    public Command newInstance() {
        return new PrintFieldDescendingGroupAdminCommand(receiver);
    }
}
