package com.alame.lab5.utility.validators;

import com.alame.lab5.elements.Coordinates;

public class CoordinatesValidator {
    public static boolean validCoordinates(Coordinates coordinates){
        return validX(coordinates.getX()) && validY(coordinates.getY());
    }
    public static boolean validX(Long x){
        return x!=null;
    }
    public static boolean validY(float y){
        return y!=Float.POSITIVE_INFINITY && y!= Float.NEGATIVE_INFINITY;
    }
}
