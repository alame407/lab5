package com.alame.lab5.utility.validators;

import com.alame.lab5.elements.Coordinates;

/**
 * class for valid coordinates fields
 */
public class CoordinatesValidator {
    /**
     * valid coordinates
     * @param coordinates - coordinates to valid
     * @return result of validation
     */
    public static boolean validCoordinates(Coordinates coordinates){
        return validX(coordinates.getX()) && validY(coordinates.getY());
    }

    /**
     * valid x
     * @param x - x to valid
     * @return result of validation
     */
    public static boolean validX(Long x){
        return x!=null;
    }

    /**
     * valid y
     * @param y - y to valid
     * @return result of validation
     */
    public static boolean validY(float y){
        return y!=Float.POSITIVE_INFINITY && y!= Float.NEGATIVE_INFINITY;
    }
}
