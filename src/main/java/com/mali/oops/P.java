package com.mali.oops;

class P {}

class C extends P {}

class Main1 {
  public void m1(P obj) {
    System.out.println("Main1");
  }
}

class Main2 extends Main1 {
  public void m1(C obj) {
    System.out.println("Main2");
  }
}

class Main3 {
  public static void main(String[] args) {
   try{
     m(42);
   } catch (CE ce){
     System.out.println("22");
   }
    Main1 m = new Main2();
    P c = new C();
    m.m1(c);

    System.out.println("Hello World");
  }

  static void m(int n) throws CE{
    throw new CE(n);
  }
}

class CE extends Exception {
  int num;

  CE(int n) {
    num = n;
  }

  public String toString() {
    return Integer.toString(num);
  }
}
