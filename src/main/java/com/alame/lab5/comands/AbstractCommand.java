package com.alame.lab5.comands;

public abstract class AbstractCommand implements Command{

    @Override
    public Command clone() {
        try {
            return (Command) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getCause());
        }
    }
}
