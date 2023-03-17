package com.alame.lab5.comands;


import com.alame.lab5.exceptions.IncorrectCommandParameterException;

/**
 * interface for all commands
 */
public interface Command{
    /**
     * execute commands
     * @return success of command execution
     */
    boolean execute();

    /**
     * set all commands parameters
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException if parameters are incorrect
     */
    void setParameters(String[] parameters) throws IncorrectCommandParameterException;

    /**
     * @return command description
     */
    String description();

    /**
     * @return command name
     */
    String name();

    /**
     * create a new instance of the same command class
     * @return new command instance
     */
    Command newInstance();
}
