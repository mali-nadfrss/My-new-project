package com.mali.ds.searchNsort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/find-median-from-data-stream/ */
public class FindMedianfromDataStream {

  //gives TLE as list does internal operations so use queue instead.
  // high level it looks 2queues takes > log(n) but list takes n+log(n) here.
  List<Integer> list;
  PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<Integer> max = new PriorityQueue<>();

  public FindMedianfromDataStream() {
    list = new LinkedList<>();
  }

  public void addNum1(int num) {
    min.offer(num);
    max.offer(min.poll());
    if (min.size() < max.size()) {
      min.offer(max.poll());
    }
  }

  public double findMedian1() {
    if (min.size() == max.size()) {
      return (double) (min.peek() + max.peek()) / 2;
    }
    return min.peek();
  }

  public void addNum(int num) {
    if (list.isEmpty()) {
      list.add(num);
      return;
    }
    int start = 0;
    int end = list.size();
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (list.get(mid) == num) {
        end = mid;
        break;
      }
      if (list.get(mid) < num) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    list.add(end, num);
  }

  public double findMedian() {
    int size = list.size();
    if (size % 2 == 0) {
      return (double) (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
    }
    return list.get(size / 2);
  }

  public static void main(String[] args) {
    FindMedianfromDataStream r = new FindMedianfromDataStream();
    r.addNum1(1);
    r.addNum1(2);
    System.out.println(r.findMedian1());
    r.addNum1(3);
    System.out.println(r.findMedian1());
  }
}
