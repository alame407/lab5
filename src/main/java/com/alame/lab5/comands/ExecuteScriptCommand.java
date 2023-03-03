package com.alame.lab5.comands;

import com.alame.lab5.App;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.input.UserInput;
import com.alame.lab5.input.readers.FileReader;
import com.alame.lab5.input.readers.commands.CommandReader;
import com.alame.lab5.input.readers.commands.file.FileCommandReader;
import com.alame.lab5.input.readers.elements.StudyGroupReader;
import com.alame.lab5.input.readers.elements.file.FileStudyGroupReader;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExecuteScriptCommand extends AbstractCommand{
    private static final Set<String> openFiles = new HashSet<>();
    private FileReader fileReader;
    private FileStudyGroupReader fileStudyGroupReader;
    private FileCommandReader fileCommandReader;
    private final Printer printer = new ConsolePrinter();
    @Override
    public boolean execute() {
        UserInput userInput = App.getUserInput();
        StudyGroupReader oldStudyGroupReader = userInput.getStudyGroupReader() ;
        CommandReader oldCommandReader = userInput.getCommandReader();
        userInput.setCommandReader(fileCommandReader);
        userInput.setStudyGroupReader(fileStudyGroupReader);
        while (fileReader.hasNextLine()){
            try{
                Command command = userInput.readCommand();
                boolean commandExecuteCorrectly = App.getCommandHandler().handle(command);
                if (!commandExecuteCorrectly){
                    printer.println("В файле " + fileReader.getFileName() + " ошибка в команде " + command.name()
                            + " все команды до выполнены успешно");
                    break;
                }
            }
            catch (IncorrectCommandParameterException e){
                printer.println("В файле " + fileReader.getFileName() + " ошибка: " + e.getMessage() +
                        " все команды до выполнены успешно");
                break;
            }
        }

        try{
            fileReader.close();
        }
        catch (IOException e){
            printer.println("Произошла ошибка при закрытии файла");
        }
        userInput.setCommandReader(oldCommandReader);
        userInput.setStudyGroupReader(oldStudyGroupReader);
        openFiles.remove(fileReader.getFileName());
        return true;
    }

    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {

        if (parameters.length!=1) throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
        if (openFiles.contains(parameters[0])){
            throw new IncorrectCommandParameterException("Такой файл уже уже открыт, " +
                    "команда execute script не выполняется для избежания рекурсии");
        }
        try{
            fileReader = new FileReader(parameters[0]);
            fileStudyGroupReader = new FileStudyGroupReader(fileReader);
            fileCommandReader = new FileCommandReader(fileReader);
            openFiles.add(fileReader.getFileName());
        } catch (IOException e) {
            throw new IncorrectCommandParameterException("Аргументы команды введены неправильно");
        }
    }

    @Override
    public String description() {
        return "execute_script file_name: считывает и исполняет скрипт из указанного файла.";
    }

    @Override
    public String name() {
        return "execute_script";
    }
}
