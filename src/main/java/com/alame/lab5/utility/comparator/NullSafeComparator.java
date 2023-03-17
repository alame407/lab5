package com.alame.lab5.utility.comparator;

/**
 * class for comparing objects that can be null
 */
public class NullSafeComparator{
    /**
     * compare objects that can be null
     * @param c1 - first object
     * @param c2 - second object
     * @return int>0 if c1>c2, 0 if c1=c2, int<0 if c1<c2
     * @param <T> any object that implements Comparable<T>
     */
    public static <T extends Comparable<T>> int compare(T c1, T c2){
        if (c1==c2) return 0;
        if (c1 == null) return -1;
        if (c2 == null) return 1;
        return c1.compareTo(c2);
    }
}
