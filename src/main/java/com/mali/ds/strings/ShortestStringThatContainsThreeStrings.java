package com.mali.ds.strings;

/* https://leetcode.com/contest/weekly-contest-356/problems/shortest-string-that-contains-three-strings/ */
public class ShortestStringThatContainsThreeStrings {

  public static String minimumString(String a, String b, String c) {
    String d = merge(merge(a, b), c);
    String e = merge(merge(b, c), a);
    String f = merge(merge(c, a), b);
    String ans = "";
    if (d.length() < e.length()) {
      if (d.length() < f.length()) ans = d;
      else if (d.length() > f.length()) ans = f;
      else ans = d.compareTo(f) > 0 ? f : d;
    } else if (d.length() > e.length()) {
      if (e.length() < f.length()) ans = e;
      else if (e.length() > f.length()) ans = f;
      else ans = e.compareTo(f) > 0 ? f : e;
    } else {
      if (f.length() < d.length()) ans = f;
      else if (f.length() > d.length()) ans = d.compareTo(e) > 0 ? e : d;
      else if (d.compareTo(e) > 0) {
        ans = e.compareTo(f) > 0 ? f : e;
      } else {
        ans = d.compareTo(f) > 0 ? f : d;
      }
    }
    return ans;
  }

  static String merge(String a, String b) {
    if (a.contains(b)) return a;
    if (b.contains(a)) return b;
    String x = "";
    String y = "";
    for (int i = 0; i < a.length(); i++) {
      if (b.startsWith(a.substring(i))) {
        x = a.substring(0, i) + b;
        break;
      }
    }
    if (x.equals("")) x = a + b;
    for (int i = 0; i < b.length(); i++) {
      if (a.startsWith(b.substring(i))) {
        y = b.substring(0, i) + a;
        break;
      }
    }
    if (y.equals("")) y = b + a;
    if (x.length() < y.length()) return x;
    if (y.length() < x.length()) return y;
    return x.compareTo(y) > 0 ? y : x;
  }

  public static void main(String[] args) {
    // "xyyyzxzyzzz"
    // "xzyzzzxyyyz"
    String a = "a", b = "c", c = "b";
    minimumString(a, b, c);
  }
}
