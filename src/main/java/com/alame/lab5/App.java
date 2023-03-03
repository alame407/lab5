package com.alame.lab5;

import com.alame.lab5.comands.Command;
import com.alame.lab5.comands.CommandHandler;
import com.alame.lab5.csv.CsvElementsLoader;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.exceptions.IncorrectKeyException;
import com.alame.lab5.input.UserInput;
import com.alame.lab5.input.readers.commands.console.ConsoleCommandReader;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.input.readers.elements.console.ConsoleStudyGroupReader;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class App {
    private static final UserInput userInput = new UserInput(new ConsoleCommandReader(), new ConsoleStudyGroupReader());
    private final static Receiver receiver = new Receiver();
    private final static CommandHandler commandHandler = new CommandHandler(receiver);
    private final Printer printer = new ConsolePrinter();

    public static UserInput getUserInput() {
        return userInput;
    }

    public static CommandHandler getCommandHandler() {
        return commandHandler;
    }
    public App(String[] args){
        if (args.length!=1){
            printer.println("В переданных аргументах не 1 параметр с название файла, " +
                    "в коллекцию ничего не загружено");
            return;
        }
        try(Reader reader = new FileReader(args[0])){
            new CsvElementsLoader(reader, receiver).load();
        }
        catch (IOException e){
            printer.println("Не удалось прочитать файл, в коллекцию ничего не загружено");
        }
        catch (IncorrectElementFieldException | IncorrectKeyException e) {
            printer.println("В файле присутствуют невалидные элементы: " + e.getMessage() +
                    ", в коллекцию ничего не загружено");
        }

    }

    public void start(){
        while (true){
            try {
                Command command = userInput.readCommand();
                commandHandler.handle(command);
            } catch (IncorrectCommandParameterException e) {
                //this shouldn't happen, since we use ConsoleReader hear
                printer.println(e.getMessage());
            }

        }
    }
}
