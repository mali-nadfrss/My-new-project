package com.mali.designPattern.creational;

/* lazy instantiation, thread safe */
public class Singleton {
    /* private constructor */
    private Singleton() {
    }

    private static class SingletonHolder {
        public static final Singleton singleton = new Singleton();
    }

    /* public static method */
    public static Singleton getSingleton() {
        return SingletonHolder.singleton;
    }
}
