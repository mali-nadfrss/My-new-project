package com.mali.ds.design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

  class Node {
    int key;
    int value;
    int counter;
    Node next;
    Node prev;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  Map<Integer, Node[]> counterMap;
  Map<Integer, Node> keyMap;
  int capacity;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.counterMap = new HashMap<>();
    this.keyMap = new HashMap<>();
  }

  public int get(int key) {
    Node n = keyMap.get(key);
    if (n != null) {
      removeCounter(n, n.counter);
      put(n.counter++, n);
      return n.value;
    }
    return -1;
  }

  public void removeCounter(Node n, int counter) {
    if (n != null) {
      Node prev = n.prev;
      Node next = n.next;
      if (prev == null && next == null) {
        counterMap.remove(counter);
      } else {
        if (prev != null) prev.next = next;
        else counterMap.get(counter)[0] = n;
        if (next != null) next.prev = prev;
        else counterMap.get(counter)[1] = n;
      }
    }
  }

  public void remove(Node n, int key) {
    keyMap.remove(key);
    removeCounter(n,n.counter);
  }

  public void put(int counter, Node n) {
    if (capacity == keyMap.size()){


    }  if (counterMap.get(counter) == null) {
      counterMap.put(counter, new Node[] {n, n});
    } else {
      counterMap.get(counter)[1] = n;
    }
  }

  public void put(int key, int value) {}

  public static void main(String[] args) {
    LFUCache obj = new LFUCache(2);
    obj.put(1, 1);
    obj.put(2, 2);
    System.out.println(obj.get(1));
    obj.put(3, 3);
    System.out.println(obj.get(2));
    System.out.println(obj.get(3));
    obj.put(4, 4);
    System.out.println(obj.get(1));
    System.out.println(obj.get(3));
    System.out.println(obj.get(4));
  }
}
