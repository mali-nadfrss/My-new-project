package com.mali.designPattern.creational;

/* https://medium.com/@257ramanrb/facade-design-pattern-389b26d88232 */
public class Facade {

  interface Mobile {
    void display();

    int price();
  }

  class Iphone implements Mobile {

    @Override
    public void display() {
      System.out.println("Iphone");
    }

    @Override
    public int price() {
      return 99999;
    }
  }

  class Samsung implements Mobile {

    @Override
    public void display() {
      System.out.println("samsung");
    }

    @Override
    public int price() {
      return 9999;
    }
  }

  class ShopKeeper {

    Mobile mobile;

    void displayMobile(String model) {
      switch (model) {
        case "Iphone":
          mobile = new Iphone();
          break;
        case "Samsung":
          mobile = new Samsung();
          break;
      }
      mobile.display();
      mobile.price();
    }
  }
}
