package com.juzo.util.collections;

import java.util.LinkedList;


public class BlockingQueue<T> {
    private final LinkedList<T> elements = new LinkedList<T>();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException {
        while (elements.size() == capacity) {
            wait();
        }
        elements.add(element);
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (elements.size() == 0) {
            wait();
        }
        T returnedElement = elements.removeLast();
        notifyAll();
        return returnedElement;
    }
}
