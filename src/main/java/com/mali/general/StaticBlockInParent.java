package com.mali.general;

public class StaticBlockInParent {
    static {
        System.out.println("static parent");
    }
    {
        System.out.println("normal parent");
    }
}
