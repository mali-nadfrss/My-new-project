package com.mali.ds.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/maximum-frequency-stack/
 * Hard */
public class MaximumFrequencyStack {

  int counter = 0;

  public class Pair {
    int value;
    int freq;
    int priority;

    Pair(int value, int freq, int priority) {
      this.value = value;
      this.freq = freq;
      this.priority = priority;
    }
  }

  Map<Integer, Pair> map;
  PriorityQueue<Pair> pq;

  public MaximumFrequencyStack() {
    this.pq =
        new PriorityQueue<>(
            (a, b) -> {
              if (a.freq == b.freq) {
                return b.priority - a.priority;
              } else {
                return b.freq - a.freq;
              }
            });

    this.map = new HashMap<>();
  }

  public void push(int val) {
    Pair p;
    if (map.get(val) == null) {
      p = new Pair(val, 1, counter);
      map.put(val, p);
      counter += 1;
    } else {
      p = new Pair(val, map.get(val).freq + 1, map.get(val).priority);
      map.get(val).freq += 1;
    }
    pq.add(p);
  }

  public int pop() {
    Pair p = pq.remove();
    return p.value;
  }

  public static void main(String[] args) {
    MaximumFrequencyStack m = new MaximumFrequencyStack();
    m.push(5);
    m.push(7);
    m.push(5);
    m.push(7);
    m.push(4);
    m.push(5);
    System.out.println(m.pop());
    System.out.println(m.pop());
    System.out.println(m.pop());
    System.out.println(m.pop());
  }
}
