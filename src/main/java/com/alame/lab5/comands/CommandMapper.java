package com.alame.lab5.comands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandMapper {
    private CommandMapper(){}
    private static class Holder{
        public static final CommandMapper HOLDER_INSTANCE = new CommandMapper();
    }
    private final Map<String,Command> stringToCommand = new HashMap<>();
    public void addCommand(String string, Command command){
        stringToCommand.put(string, command);
    }
    public void addAllCommands(Map<String, Command> stringCommandMap){
        stringToCommand.putAll(stringCommandMap);
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


    public static CommandMapper getInstance() {
        return Holder.HOLDER_INSTANCE;
    }
}
