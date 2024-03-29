package com.alame.lab5.comands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * class for matching string and command
 */
public class CommandMapper {
    private CommandMapper(){}

    /**
     * class for holding CommandMapper INSTANCE
     */
    private static class Holder{
        public static final CommandMapper HOLDER_INSTANCE = new CommandMapper();
    }

    /**
     * field that store match string and command
     */
    private final Map<String,Command> stringToCommand = new HashMap<>();

    /**
     * add match string and command
     * @param string - string representation of command
     * @param command - concrete command
     */
    public void addCommand(String string, Command command){
        stringToCommand.put(string, command);
    }

    /**
     * add all matches strings and commands
     * @param stringCommandMap - map of matches strings and commands
     */
    public void addAllCommands(Map<String, Command> stringCommandMap){
        stringToCommand.putAll(stringCommandMap);
    }

    /**
     * @param string - string representation of command
     * @return string representation is exists
     */
    public boolean commandExist(String string){
        return stringToCommand.containsKey(string);
    }

    /**
     * @param string - string representation of command
     * @return new command instance
     */
    public Command getNewCommandInstanceByString(String string){
        return stringToCommand.get(string).newInstance();
    }

    /**
     * @return all stored commands
     */
    public Collection<Command> getAllCommands(){
        return stringToCommand.values();
    }

    /**
     * @return INSTANCE of CommandMapper
     */
    public static CommandMapper getInstance() {
        return Holder.HOLDER_INSTANCE;
    }
}
