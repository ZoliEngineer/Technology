package com.juzo.util.counter;

public class UnsafeCounter implements ConcurrentCounter {
    private int counter = 0;

    @Override
    public void increment(int callerId) {
        counter++;

    }

    @Override
    public int get() {
        return counter;
    }

}
