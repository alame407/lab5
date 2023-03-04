package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.executors.Executor;
import com.alame.lab5.utility.structers.LimitedQueue;

import java.util.*;

public class CommandHandler {
    private final Map<String,Command> stringToCommand;
    private final Queue<String> history = new LimitedQueue<>(12);
    private final Executor executor = new Executor();

    public CommandHandler(Receiver receiver){
        stringToCommand = new HashMap<>()
        {
            {
                put("help", new HelpCommand());
                put("info", new InfoCommand(receiver));
                put("insert", new InsertCommand(receiver));
                put("show", new ShowCommand(receiver));
                put("update", new UpdateCommand(receiver));
                put("remove_key", new RemoveKeyCommand(receiver));
                put("clear", new ClearCommand(receiver));
                put("save", new SaveCommand(receiver));
                put("execute_script", new ExecuteScriptCommand());
                put("exit", new ExitCommand());
                put("history", new HistoryCommand());
                put("replace_if_lower", new ReplaceIfLowerCommand(receiver));
                put("remove_lower_key", new RemoveLowerKeyCommand(receiver));
                put("remove_all_by_form_of_education", new RemoveAllByFormOfEducationCommand(receiver));
                put("max_by_creation_date", new MaxByCreationDateCommand(receiver));
                put("print_field_descending_group_admin", new PrintFieldDescendingGroupAdminCommand(receiver));
            }
        };
    }
    public boolean commandExist(String string){
        return stringToCommand.containsKey(string);
    }
    public Command getNewCommandInstanceByString(String string){
        return stringToCommand.get(string).clone();
    }
    public Collection<Command> getAllCommands(){
        return stringToCommand.values();
    }
    public boolean handle(Command command){
        executor.setCommand(command);
        if(executor.executeCommand()){
            addCommandToHistory(command);
            return true;
        }
        return false;
    }
    private void addCommandToHistory(Command command){
        history.add(command.name());
    }

    public Queue<String> getHistory() {
        return history;
    }
}
