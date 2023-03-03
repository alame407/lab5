package com.alame.lab5.elements;

import java.util.Arrays;

public enum Country {
    RUSSIA,
    VATICAN,
    SOUTH_KOREA;
    private static final String possibleValues = Arrays.toString(values());
    public static String possibleValues(){
        return possibleValues;
    }
}
