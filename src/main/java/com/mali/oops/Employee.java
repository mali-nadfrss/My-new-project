package com.mali.oops;

public class Employee {

  String name;
 public int id;
  String email;

  public Employee(){

  }

  String getName(){
    return this.name;
  }


  static int sum(int k, int l) {
    return k + l;
  }

  static int multiply(int k, int j) {
    return k * j;
  }

  public static void main(String[] args) {

    int m = multiply(28, 39);
    int f = sum(45, m);
    f = sum(f, 3456);
    multiply(f, 67);
    System.out.println(f); // 28*39 + 45
  }
}
