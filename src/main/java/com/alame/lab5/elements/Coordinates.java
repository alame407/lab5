package com.alame.lab5.elements;

import java.util.Comparator;

public class Coordinates implements Comparable<Coordinates>{
    private Long x; //Поле не может быть null
    private float y;
    public Coordinates(){}
    public Coordinates(Long x, float y){
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public Long getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "" + x +
                ", " + y +
                '}';
    }

    @Override
    public int compareTo(Coordinates o) {
        return Comparator.comparing(Coordinates::getX).thenComparing(Coordinates::getY).compare(this, o);
    }
}
