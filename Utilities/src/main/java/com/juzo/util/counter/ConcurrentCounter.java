package com.juzo.util.counter;

public interface ConcurrentCounter {
    void increment(int callerId);

    int get();
}
