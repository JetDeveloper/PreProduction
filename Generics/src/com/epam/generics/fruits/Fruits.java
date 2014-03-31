/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.generics.fruits;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class Fruit {
}

class Apple extends Fruit implements Comparable<Apple> {
    
    private int mass;
    
    @Override
    public int compareTo(Apple o) {
        if (mass == o.mass) {
            return 0;
        } else if (mass > o.mass) {
            return 1;
        } else {
            return -1;
        }
    }
}

class RedApple extends Apple {
}

class Orange extends Fruit {
}

class Melon {
}

/**
 *
 * @author Dmytro_Svynarenko
 */
public class Fruits {
    
    static <K extends Fruit> void copyAll(Collection<? extends K> collection, Collection<K> out) {
        out.addAll(collection);    
    }

    public static void main(String[] args) {
        List<Fruit> fr = null;
        List<Apple> app = null;
        List<Orange> or = null;
        List<RedApple> rapp = null;
        List<Melon> mel = null;
        
        copyAll(or, fr);
        copyAll(rapp, fr);
        copyAll(rapp, app);
        copyAll(rapp, rapp);
    }
}
