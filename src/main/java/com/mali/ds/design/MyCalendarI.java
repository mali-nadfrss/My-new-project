package com.mali.ds.design;

import java.util.TreeMap;

/* https://leetcode.com/problems/my-calendar-i/
 * medium */
public class MyCalendarI {

  TreeMap<Integer, Integer> map;

  public MyCalendarI() {
    map = new TreeMap<>();
  }
int i = 0;
  public boolean book(int start, int end) {
    Integer floorStart = map.floorKey(start);
    Integer floorEnd = map.floorKey(end-1);
    System.out.println(i++);
    if ((floorStart != null && map.get(floorStart) > start )|| (floorEnd != null && floorEnd > start && floorEnd < end)) return false;
    map.put(start, end);
    return true;
  }

  public static void main(String[] args) {
    MyCalendarI cal = new MyCalendarI();

    System.out.println(cal.book(20,29));
    System.out.println(cal.book(13,22));
    System.out.println(cal.book(44,50));
    System.out.println(cal.book(1 , 7));
    System.out.println(cal.book(2 ,10));
    System.out.println(cal.book(14,20));
    System.out.println(cal.book(19,25));
    System.out.println(cal.book(36,42));
    System.out.println(cal.book(45,50));
    System.out.println(cal.book(47,50));
    System.out.println(cal.book(39,45));
    System.out.println(cal.book(44,50));
    System.out.println(cal.book(16,25));
    System.out.println(cal.book(45,50));
    System.out.println(cal.book(45,50));
    System.out.println(cal.book(12,20));
    System.out.println(cal.book(21,29));
    System.out.println(cal.book(11,20));
    System.out.println(cal.book(12,17));
    System.out.println(cal.book(34,40));
    System.out.println(cal.book(10,18));
    System.out.println(cal.book(38,44));
    System.out.println(cal.book(23,32));
    System.out.println(cal.book(38,44));
    System.out.println(cal.book(15,20));
    System.out.println(cal.book(27,33));
    System.out.println(cal.book(34,42));
    System.out.println(cal.book(44,50));
    System.out.println(cal.book(35,40));
    System.out.println(cal.book(24,31));
  }
}
