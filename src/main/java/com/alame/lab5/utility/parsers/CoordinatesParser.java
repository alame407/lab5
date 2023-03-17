package com.alame.lab5.utility.parsers;

import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.utility.validators.CoordinatesValidator;

/**
 * class for parsing coordinates from string
 */
public class CoordinatesParser {
    /**
     * parse x from string
     * @param s - string to parse
     * @return x
     * @throws IncorrectElementFieldException if x is not valid
     */
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

    /**
     * parse y from string
     * @param s - string to parse
     * @return y
     * @throws IncorrectElementFieldException if y is not valid
     */
    public static float parseY(String s) throws IncorrectElementFieldException {
        try{
            float y = Float.parseFloat(s);
            if (CoordinatesValidator.validY(y)) return y;
            throw new IncorrectElementFieldException("Координата y должна быть дробным числом числом типа float");
        }
        catch (NumberFormatException | NullPointerException e){
            throw new IncorrectElementFieldException("Координата y должна быть дробным числом числом типа float");
        }
    }
}
