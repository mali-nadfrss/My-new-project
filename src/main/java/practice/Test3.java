package practice;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Test3 {

  static int[] arr = {15, 10, 16, 20, 8, 9, 7, 50};
  // int[] ans = {16,16,20,50,9,50,50,-1};

  static void find() {
    TreeSet<Integer> set = new TreeSet<>();
    Integer k = set.ceiling(8);
    set.floor(8);
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // 50,20,16
    int len = arr.length;
    int[] ans = new int[len];
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!pq.isEmpty() && pq.peek() <= arr[i]) {
        pq.poll();
      }
      if (pq.isEmpty()) {
        ans[i] = -1;
      } else {
        ans[i] = pq.peek();
      }
      pq.offer(arr[i]);
    }

    for (int i : ans) {
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    find();
  }
}
