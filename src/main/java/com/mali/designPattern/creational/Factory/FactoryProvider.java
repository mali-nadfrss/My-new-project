package com.mali.designPattern.creational.Factory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String type){
        if ("Shape".equals(type)){
            return new ShapeFactory();
        }
        return sides -> null;
    }
}
