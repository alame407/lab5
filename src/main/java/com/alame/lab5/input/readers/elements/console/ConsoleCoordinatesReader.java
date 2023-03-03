package com.alame.lab5.input.readers.elements.console;

import com.alame.lab5.elements.Coordinates;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.readers.ConsoleReader;
import com.alame.lab5.utility.parsers.CoordinatesParser;
import com.alame.lab5.utility.writers.ConsolePrinter;
import com.alame.lab5.utility.writers.Printer;

public class ConsoleCoordinatesReader extends ConsoleReader {
    private final Printer printer = new ConsolePrinter();
    public Coordinates readCoordinates(){
        return new Coordinates(readX(), readY());
    }
    public Long readX(){
        printer.print("Введите координату x ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try{
                return CoordinatesParser.parseX(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }
    public float readY(){
        printer.print("Введите координату y ");
        while(true){
            String nextLine = getNextLine();
            if (nextLine.equals("")) nextLine = null;
            try{
                return CoordinatesParser.parseY(nextLine);
            }
            catch (IncorrectElementFieldException e){
                printer.print(e.getMessage() + ", повторите ввод ");
            }
        }
    }
}
