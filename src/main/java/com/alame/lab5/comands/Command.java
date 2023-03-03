package com.alame.lab5.comands;


import com.alame.lab5.exceptions.IncorrectCommandParameterException;

public interface Command extends Cloneable{
    boolean execute();
    void setParameters(String[] parameters) throws IncorrectCommandParameterException;
    String description();
    String name();
    Command clone();
}
