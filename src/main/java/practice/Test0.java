package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test0 {

  /*
  list1 = [3,5,7,8]
  list2 = [1,5,4,8]

  output :::
  samelist[5,8]
  difflist[3,7,1,4]"
  */

  static void filterElements() {

    List<Integer> list1 = new ArrayList<>();
    list1.add(3);
    list1.add(5);
    list1.add(7);
    list1.add(8);
    List<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(5);
    list2.add(4);
    list2.add(8);

    System.out.println(list1.stream().filter(a -> list2.contains(a)).collect(Collectors.toList()));

    List<Integer> res = list1.stream().filter(a -> !list2.contains(a)).collect(Collectors.toList());
    res.addAll(list2.stream().filter(a -> !list1.contains(a)).collect(Collectors.toList()));
    System.out.println(res);
  }

  public static void main(String[] args) {

    EvenThread t1 = new EvenThread();
    OddThread t2 = new OddThread();
    t2.start();
    t1.start();

  }


  public static class EvenThread extends Thread {

    public void run() {

      for (int i = 1; i < 7; ) {
        if (lock == 1) {
          this.notify();
        }
        if (i % 2 == 0) {
          System.out.println(i);
          lock = 1;
          i++;
        }
      }
    }
  }

  static int lock = 0;

  public static class OddThread extends Thread {
    public void run() {

      for (int i = 1; i < 7; ) {
        if (lock == 0) {
          this.notify();
          if (i % 2 != 0) {
            System.out.println(i);
            i++;
            lock = 0;
          }
        }
      }
    }
  }
}
