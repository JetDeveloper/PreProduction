/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.generics.fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit implements Comparable<Apple> {

    private int mass;

    public Apple(int mass) {
        this.mass = mass;
    }

    public int getMass() {
        return mass;
    }

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

    public RedApple(int mass) {
        super(mass);
    }
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

    static <K extends Fruit> void copyAll(Collection<? extends K> collection,
            Collection<? super K> out) {
        out.addAll(collection);
    }

    static <K extends Apple> Collection<K> returnAllGreaterThan(Collection<? extends K> collection,
            K apple) {
        
        Collection<K> result = new LinkedList<>();
        for (K item : collection) {
            if (item.compareTo(apple) >= 0) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Fruit> fr = new ArrayList<>();
        List<Apple> app = new ArrayList<>();
        List<Orange> or = new ArrayList<>();
        List<RedApple> rapp = new ArrayList<>();
        List<Melon> mel = new ArrayList<>();
        fr.add(new Fruit());
        or.add(new Orange());
        rapp.add(new RedApple(10));
        rapp.add(new RedApple(15));
        app.add(new Apple(5));
        mel.add(new Melon());

      //  copyAll(or, fr);
      //  copyAll(rapp, fr);
      //  copyAll(rapp, app);
     //   copyAll(rapp, rapp);
         copyAll(rapp, app);
         System.out.println(app);
         System.out.println(returnAllGreaterThan(app, new Apple(10)));
    }
}
