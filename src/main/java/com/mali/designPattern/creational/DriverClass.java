package com.mali.designPattern.creational;

import com.mali.designPattern.creational.Factory.ShapeFactory;

public class DriverClass {
    public static void main(String[] args) throws Exception {
        System.out.println(Singleton.getSingleton());
        System.out.println(Singleton.getSingleton());
        System.out.println(new ShapeFactory().getShape(3));
        Builder builder = new Builder(1,"a");
        System.out.println(builder.setAge(12));
        System.out.println(builder.setAddress("xyz"));
    }
}
