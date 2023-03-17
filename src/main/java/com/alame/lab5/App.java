package com.alame.lab5;

import com.alame.lab5.comands.*;
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
import java.util.HashMap;
import java.util.Map;

public class App {
    private final UserInput userInput = new UserInput(new ConsoleCommandReader(), new ConsoleStudyGroupReader());
    private final Receiver receiver = new Receiver();
    private final CommandHandler commandHandler = new CommandHandler();
    private final Printer printer = new ConsolePrinter();

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
        catch(IllegalArgumentException e){
            printer.println("файл должен должен быть в формате: key, id, name, Coordinates x, Coordinates y, creationDate,"
                    + "studentsCount, expelledStudents, formOfEducation, semesterEnum, groupAdmin name," +
                    "groupAdmin birthday, groupAdmin eyeColor, groupAdmin hairColor, groupAdmin nationality" +
                    " разделенные запятыми, в коллекцию ничего не загружено");
        }
        Map<String, Command> stringToCommand = new HashMap<>()
        {
            {
                put("help", new HelpCommand());
                put("info", new InfoCommand(receiver));
                put("insert", new InsertCommand(receiver, userInput));
                put("show", new ShowCommand(receiver));
                put("update", new UpdateCommand(receiver, userInput));
                put("remove_key", new RemoveKeyCommand(receiver));
                put("clear", new ClearCommand(receiver));
                put("save", new SaveCommand(receiver));
                put("execute_script", new ExecuteScriptCommand(userInput,commandHandler));
                put("exit", new ExitCommand());
                put("history", new HistoryCommand(commandHandler));
                put("replace_if_lower", new ReplaceIfLowerCommand(receiver, userInput));
                put("remove_lower_key", new RemoveLowerKeyCommand(receiver));
                put("remove_all_by_form_of_education", new RemoveAllByFormOfEducationCommand(receiver, userInput));
                put("max_by_creation_date", new MaxByCreationDateCommand(receiver));
                put("print_field_descending_group_admin", new PrintFieldDescendingGroupAdminCommand(receiver));
            }
        };
        CommandMapper.getInstance().addAllCommands(stringToCommand);
    }

    public void start(){
        while (true){
            try {
                Command command = userInput.getCommandReader().readCommand();
                commandHandler.handle(command);
            } catch (IncorrectCommandParameterException e) {
                printer.println(e.getMessage());
            }

        }
    }
}
