package com.juzo.util.counter;

public class SyncronizedCounter implements ConcurrentCounter {
    private int counter = 0;

    @Override
    public synchronized void increment(int callerId) {
        counter++;
    }

    @Override
    public synchronized int get() {
        return counter;
    }

}
