package com.juzo.util.counter;

public class NonBlockingCounter implements ConcurrentCounter {
    private final int[] counter;

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
