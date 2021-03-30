package com.mali.general;

import java.util.HashMap;
import java.util.Map;

public class StaticBlockChild extends StaticBlockInParent {
  static {
    System.out.println("child static");
  }

  {
    System.out.println("normal child");
  }

  public static void main(String[] args) throws Exception {
    StaticBlockChild staticBlockChild = new StaticBlockChild();

    Map<String, String> map = new HashMap<>();
    map.put("anc", "sfa");
    System.out.println(map);
  }
}
