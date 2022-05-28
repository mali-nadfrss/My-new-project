package com.mali.oops;

import java.util.List;

public class Manager extends Employee {

    List<Employee> listOfEmployees ;

    void  printDetails(){
        String k = getName();

        System.out.println("Name: "+name);
    }

}
