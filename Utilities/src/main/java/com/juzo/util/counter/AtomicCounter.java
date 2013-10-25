package com.juzo.util.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements ConcurrentCounter {
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void increment(int callerId) {
        counter.incrementAndGet();

    }

    @Override
    public int get() {
        return counter.get();
    }

}
