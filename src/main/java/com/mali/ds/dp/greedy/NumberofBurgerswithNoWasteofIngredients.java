package com.mali.ds.dp.greedy;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 * medium */
public class NumberofBurgerswithNoWasteofIngredients {

  public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

    List<Integer> ans = new ArrayList<>();
    if (cheeseSlices > tomatoSlices
        || tomatoSlices > 4 * cheeseSlices
        || tomatoSlices < 2 * cheeseSlices
        || tomatoSlices % 2 == 1) {
      return ans;
    }
    int jubmo = (tomatoSlices - 2 * cheeseSlices) / 2;
    ans.add(jubmo);
    ans.add(cheeseSlices - jubmo);
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(numOfBurgers(4, 17));
  }
}
