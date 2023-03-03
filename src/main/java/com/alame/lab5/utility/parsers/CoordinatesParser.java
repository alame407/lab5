package com.alame.lab5.utility.parsers;

import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.utility.validators.CoordinatesValidator;

public class CoordinatesParser {
    public static Long parseX(String s) throws IncorrectElementFieldException {
        try{
            Long x = Long.parseLong(s);
            if (CoordinatesValidator.validX(x)) return x;
            throw new IncorrectElementFieldException("Координата x должна быть целым числом");
        }
        catch (NumberFormatException e){
            throw new IncorrectElementFieldException("Координата x должна быть целым числом");
        }
    }
    public static float parseY(String s) throws IncorrectElementFieldException {
        try{
            float y = Float.parseFloat(s);
            if (CoordinatesValidator.validY(y)) return y;
            throw new IncorrectElementFieldException("Координата y должна быть дробным числом числом");
        }
        catch (NumberFormatException | NullPointerException e){
            throw new IncorrectElementFieldException("Координата y должна быть дробным числом числом");
        }
    }
}
