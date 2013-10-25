package com.juzo.util.counter;

public class PaddedNonBlockingCounter implements ConcurrentCounter {
    private final int[] counter; // TODO: introduce padding in a new structure

    public NonBlockingCounter(int threadCount){
        counter = new int[threadCount];
    }

    @Override
    public void increment(int callerId) {
        counter[callerId]++; // TODO: not safe for ArrayIndexOutOfBoundsException
    }

    @Override
    public int get() {
        int aggregatedCounter = 0;
        for(int i : counter){
            aggregatedCounter += i;
        }
        return aggregatedCounter;
    }

}
