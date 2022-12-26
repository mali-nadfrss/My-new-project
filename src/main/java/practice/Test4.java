package practice;

import java.util.Arrays;

public class Test4 {

  // Given a string you need to print the size of the longest possible substring that has exactly K
  // unique characters. If there is no possible substring then print -1.

  // String = "aabacbebebe", K = 3
  // Output: 7

  // String = "aaaa", K = 2
  // Output: -1
  // aabacbebebe

  int longestKSubstring(String s, int k) {

    int[] charArr = new int[26]; // 0->3, 1->5, 3->4,5->6
    int start = 0; // 4
    int ans = -1;
    int count = 0; // 3
    Arrays.fill(charArr, -1);
    // aabacbebebe
    for (int i = 0; i < s.length(); i++) {
      if (charArr[s.charAt(i) - 'a'] == -1) {
        count++;
      }
      charArr[s.charAt(i) - 'a'] = i;
      if (count > k) {
        ans = Math.max(ans, i - start);
        count -= 1;
        int temp = getMinPos(charArr);
        start = charArr[temp] + 1;
        charArr[temp] = -1;
      }
    }
    if (count == k) ans = Math.max(ans, s.length() - start);
    return ans;
  }

  int getMinPos(int[] arr) {

    int val = Integer.MAX_VALUE;
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > -1 && arr[i] < val) {
        val = arr[i];
        ans = i;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Test4 t = new Test4();
    System.out.println(t.longestKSubstring("aabacbebebe", 3));
    System.out.println(t.longestKSubstring("abbbbcacdeeef", 2));
    System.out.println(t.longestKSubstring("aaaa", 2));
  }
}
