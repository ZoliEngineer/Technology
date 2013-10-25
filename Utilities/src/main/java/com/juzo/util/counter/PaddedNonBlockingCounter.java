package com.juzo.util.counter;

public class PaddedNonBlockingCounter implements ConcurrentCounter {
    private static final int PADDING_SIZE = 8;
     private static final int IN_PADDING_POSIION = 4;
    
    private final int[][] counter;   // Simplest solution, needs analysis if a dedicated object with encapsulates padding performs better

    public NonBlockingCounter(int threadCount){
        counter = new int[threadCount][PADDING_SIZE];
    }

    @Override
    public void increment(int callerId) {
        counter[callerId][IN_PADDING_POSIION]++; // TODO: not safe for ArrayIndexOutOfBoundsException
    }

    @Override
    public int get() {
        int aggregatedCounter = 0;
        for(int[] i : counter){
            aggregatedCounter += i[IN_PADDING_POSIION];
        }
        return aggregatedCounter;
    }

}
