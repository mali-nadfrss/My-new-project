package com.mali.ds.arrays;

/* https://leetcode.com/contest/biweekly-contest-94/problems/minimize-the-maximum-of-two-arrays/*/
public class MinimizetheMaximumofTwoArrays {

  public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {

    int previous = -1;
    int cur = 1;
    int c1 = 0;
    int c2 = 0;
    boolean flag = false;

    while (c1 != uniqueCnt1 && c2 != uniqueCnt2) {

      if (cur % divisor1 == 0 && cur % divisor2 == 0) {
        cur++;
        continue;
      }

      if (!flag && c1 <= uniqueCnt1 && cur % divisor1 != 0) {
        c1++;
        previous = cur;
        flag = !flag;
      } else if (flag && c2 <= uniqueCnt2 && cur % divisor2 != 0) {
        c2++;
        previous = cur;
        flag = !flag;
      } else if (!flag
          && c1 <= uniqueCnt1
          && previous % divisor1 != 0
          && c2 <= uniqueCnt2
          && cur % divisor2 != 0) {

        c1++;
        previous = cur;
        flag = !flag;

      } else if (flag
          && c1 <= uniqueCnt1
          && previous % divisor2 != 0
          && c2 <= uniqueCnt2
          && cur % divisor1 != 0) {
        c2++;
        previous = cur;
        flag = !flag;
      }

      cur++;
    }

    if (c1 == uniqueCnt1) {
      if (cur % divisor2 == 0 && previous % divisor1 != 0) {
        cur++;
        c2++;
      }
      cur = cal(uniqueCnt2, c2, cur, divisor2);
    } else {
      if (cur % divisor1 == 0 && previous % divisor2 != 0) {
        cur++;
        c1++;
      }
      cur = cal(uniqueCnt1, c1, cur, divisor1);
    }

    return cur - 1;
  }

  static int cal(int count, int cur, int val, int divisor) {

    while (cur < count) {
      if (val % divisor != 0) {

        cur++;
      }
      val++;
    }
    return val;
  }

  public static void main(String[] args) {
    System.out.println(minimizeSet(9, 4, 8, 3));
    //1,2,9 , 3456781011
  }
}
