package com.mali.designPattern.creational;

import com.mali.designPattern.creational.Factory.ShapeFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverClass {
    public static void main(String[] args) throws Exception {
        System.out.println(Singleton.getSingleton());
        System.out.println(Singleton.getSingleton());
        System.out.println(new ShapeFactory().getShape(3));
        Builder builder = new Builder(1,"a");
        System.out.println(builder.setAge(12));
        System.out.println(builder.setAddress("xyz"));


            // Let us create a list of strings
            List<String> mylist = new ArrayList<String>();
            mylist.add("practice");
            mylist.add("code");
            mylist.add("quiz");
            mylist.add("geeksforgeeks");

            System.out.println("Original List : " + mylist);

            // Here we are using rotate() method
            // to rotate the element by distance 2
            Collections.rotate(mylist, -2);

            System.out.println(Math.round(2.5+Math.random()));

            double  a = 130.09;
            byte b = (byte)a;
        System.out.println(b);

    }
}
