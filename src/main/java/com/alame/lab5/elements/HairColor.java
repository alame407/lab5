package com.alame.lab5.elements;

import java.util.Arrays;

public enum HairColor {
    GREEN,
    RED,
    ORANGE,
    WHITE;
    private static final String possibleValues = Arrays.toString(values());
    public static String possibleValues(){
        return possibleValues;
    }
}
