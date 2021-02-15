package com.mali;
/*
public class Test extends Max{

        public static void main(String [] args)
        {
            *//*int x = 0x80000000;
            System.out.print(x + " and ");
            x = x >>> 31;
            System.out.println(x);*//*

            *//*String __$1____str="These Variables!";
            String $s=__$1___str;
            int a=31,b=a++;
            int @q=12;
            if ($s=="These Variables")
                System.out.println("True");
            else
                System.out.println("False");*//*
            *//*int A1[] = {1, 2, 3};
            int A2[] = {1, 2, 3};
            if (A1.equals(A2))
                System.out.println("Same");
            else
                System.out.println("Not same");*//*

            Test test = new Test();
            String Push = null;
            if(Push!="null")
                System.out.print("Passed");
            else
                System.out.print("Failed");
            test.Pass(Push);
            System.out.print(Push);
        }

    public void Pass(String arg)
    {
        arg = "You've got it in you!!";
    }
    public static int method()
    {
        try
        {
            System.out.println("try");
            int x =33/0;
            System.out.println(11);
            return 11;
        }
        catch(Exception e)
        {
            System.out.println("catch");
            System.out.println(17);
            return 17;
        }
        finally
        {
            System.out.println("finally");
            System.out.println(88);
            return 88;
        }
    }

}*/

import com.mali.ds.hashing.MaxDistance;

import java.util.ArrayList;
import java.util.List;

class Test extends MaxDistance
{

    public int maxDistance(int arr[], int n)  {
        return 1;
    }
    /*


    final StringBuffer str1 = new StringBuffer();
    final StringBuffer str2 = new StringBuffer();

    public static void main(String args[])
    {
        final Test obj = new Test();

        new Thread()
        {
            public void run()
            {
                synchronized(this)
                {
                    obj.str1.append("1");
                    obj.str2.append("A");
                    System.out.println(obj.str1);
                    System.out.println(obj.str2);
                }
            }
        }.start();

        new Thread()
        {
            public void run()
            {
                synchronized(this)
                {
                    obj.str1.append("2");
                    obj.str2.append("B");
                    System.out.println(obj.str2);
                    System.out.println(obj.str1);
                }
            }
        }.start();
    }*/

    public static void Order(String s)
    {
        System.out.println("String");
    }
    public static void Order(Object o)
    {
        System.out.println("Object");
    }
    public static void main (String [] args)
    {

        List<String> l = new ArrayList<>();
        l.stream().map((va)-> {
            return 1;
        }).count();
    }

}
