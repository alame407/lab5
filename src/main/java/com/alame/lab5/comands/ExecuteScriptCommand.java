package com.alame.lab5.comands;

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

public class ExecuteScriptCommand implements Command{
    private static final Set<String> openFiles = new HashSet<>();
    private FileReader fileReader;
    private StudyGroupReader studyGroupReader;
    private CommandReader commandReader;
    private final Printer printer = new ConsolePrinter();
    private final UserInput userInput;
    private final CommandHandler commandHandler;
    public ExecuteScriptCommand(UserInput userInput, CommandHandler commandHandler){
        this.userInput = userInput;
        this.commandHandler = commandHandler;
    }
    @Override
    public boolean execute() {
        openFiles.add(fileReader.getFileName());
        StudyGroupReader oldStudyGroupReader = userInput.getStudyGroupReader() ;
        CommandReader oldCommandReader = userInput.getCommandReader();
        userInput.setCommandReader(commandReader);
        userInput.setStudyGroupReader(studyGroupReader);
        while (fileReader.hasNextLine()){
            try{
                Command command = userInput.getCommandReader().readCommand();
                boolean commandExecuteCorrectly = commandHandler.handle(command);
                if (!commandExecuteCorrectly){
                    printer.println("В файле " + fileReader.getFileName() + " ошибка в команде " + command.name());
                }
            }
            catch (IncorrectCommandParameterException e){
                printer.println("В файле " + fileReader.getFileName() + " ошибка: " + e.getMessage());
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

        if (parameters.length!=1)
            throw new IncorrectCommandParameterException("Данная команда принимает 1 аргумент - название файла");
        if (openFiles.contains(parameters[0])){
            throw new IncorrectCommandParameterException("Такой файл уже уже открыт, " +
                    "команда execute script не выполняется для избежания рекурсии");
        }
        try{
            fileReader = new FileReader(parameters[0]);
            studyGroupReader = new FileStudyGroupReader(fileReader);
            commandReader = new FileCommandReader(fileReader);
        } catch (IOException e) {
            throw new IncorrectCommandParameterException("Не удалось открыть указанный файл");
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

    @Override
    public Command newInstance() {
        return new ExecuteScriptCommand(userInput, commandHandler);
    }
}
