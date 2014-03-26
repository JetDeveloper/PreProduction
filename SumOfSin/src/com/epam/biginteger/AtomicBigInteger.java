/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.biginteger;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author Dmytro_Svynarenko
 */
public final class AtomicBigInteger {

    private final AtomicReference<BigInteger> valueHolder = new AtomicReference<>();

    public AtomicBigInteger(BigInteger bigInteger) {
        valueHolder.set(bigInteger);
    }

    public BigInteger incrementAndGet() {
        for (;;) {
            BigInteger current = valueHolder.get();
            BigInteger next = current.add(current);
            
            if (valueHolder.compareAndSet(current, next)) {
                System.out.println(next);
                return next;
            }
        }
    }

    @Override
    public  synchronized  String toString() {
        return valueHolder.get().toString();
    }
    
}
