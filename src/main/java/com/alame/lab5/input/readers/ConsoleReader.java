package com.alame.lab5.input.readers;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);
    protected String getNextLine(){
        String string = "";
        try{
            string = scanner.nextLine();
        }
        catch (NoSuchElementException  e){
            System.exit(0);
        }
        return string;
    }
}
