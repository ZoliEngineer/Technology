package com.juzo.poc.patterns.singleton;

public class Singleton {
    private Singleton() {

    }

    public Singleton get() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private final static Singleton INSTANCE = new Singleton();
    }

}
