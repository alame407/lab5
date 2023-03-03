package com.alame.lab5.elements;

import java.util.Arrays;

public enum Semester {
    FIRST,
    SIXTH,
    SEVENTH,
    EIGHTH;
    private static final String possibleValues = Arrays.toString(values());
    public static String possibleValues(){
        return possibleValues;
    }
}
