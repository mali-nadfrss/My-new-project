package com.mali.general;

public class StaticBlockChild extends StaticBlockInParent {
    static {
        System.out.println("child static");
    }

    {
        System.out.println("normal child");
    }

    public static void main(String[] args) throws Exception {
        StaticBlockChild staticBlockChild = new StaticBlockChild();
    }
}
