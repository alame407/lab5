package com.alame.lab5.utility.writers;

public class ConsolePrinter implements Printer{
    public void print(String text){
        System.out.print(text);
    }
    public void print(Object object){
        System.out.print(object);
    }
    public void println(String text){
        System.out.println(text);
    }
    public void println(Object object){
        System.out.println(object);
    }
}
