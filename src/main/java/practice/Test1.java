package practice;

import java.util.Arrays;

public class Test1 {




  // array[1,2,3,4] --> [3,4,1,2] --> 12341234 n 2n
  // arr, k%n
  // 4321 4123
  // 12345  54321 45123 n, 2n
  Test1(int[] arr) {}

  static int[] reverseArray(int[] arr, int n) {
    int len = arr.length;
    n = n % len;

    // reverse the array
    for (int i = 0; i < len / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[len - i - 1];
      arr[len - i - 1] = temp;
    }

    // reverse the first n positions 4321
    for (int i = 0; i < n / 2; i++) {
      int temp = arr[i]; // 4
      arr[i] = arr[n - i - 1]; // 2-0-1 = 1
      arr[n - i - 1] = temp;
    }

    // reverse the rest n positions //3421
    int j = 0;
    for (int i = n; i < (len + n) / 2; i++) {
      int temp = arr[i]; // 2
      arr[i] = arr[len - j - 1]; // 4-(2+0+1)
      arr[len - j - 1] = temp;
      j++;
    }

    return arr;
  }

  // older[], younger[]
  // LRU [2<>3<>5<>6<>4] doubly linkedlist
  // Map<5, node(5)>
  public static boolean add() {

    return true;
  }

  //  Input: [1, 3, 15, 11, 2], [23, 127, 235, 19, 8]
  // Output: [11, 8]

  // 1,2,3,11,15
  // 8,19,23,127,235

  static int[] minimumDiff(int[] arr1, int[] arr2) {

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    int a = arr1[0];
    int b = arr2[0];

    int diff = Integer.MAX_VALUE;
    for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ) {
     int temp = Math.abs(arr1[i] - arr2[j]);
      if (temp < diff) {
        a = arr1[i];
        b = arr2[j];
        diff = temp;
      }
      if (arr1[i] > arr2[j]) {
        j++;
      } else {
        i++;
      }
    }
    return new int[] {a, b};
  }

  public static void main(String[] args) {


  }

}
