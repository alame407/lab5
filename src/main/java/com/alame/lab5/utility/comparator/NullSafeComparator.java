package com.alame.lab5.utility.comparator;


public class NullSafeComparator{
    public static <T extends Comparable<T>> int compare(T c1, T c2){
        if (c1==c2) return 0;
        if (c1 == null) return -1;
        if (c2 == null) return 1;
        return c1.compareTo(c2);
    }
}
