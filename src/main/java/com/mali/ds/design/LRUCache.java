package com.mali.ds.design;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/lru-cache/
 * medium */
/* Use Doubly linked List to get O(1) time for all operations */
public class LRUCache {

  class Node {

    int key;
    int value;
    Node prev;
    Node next;

    Node(int key,int value) {
      this.value = value;
      this.key = key;
    }
  }

  Node tail;
  Node head;
  int capacity;
  int size;
  Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.size = 0;
  }

  public int get(int key) {

    Node n = map.get(key);
    if (n != null) {
      if (n ==head ){
        return n.value;
      }
      if(tail == n){
        tail = n.next;
        tail.prev = null;
      } else{
        n.prev.next = n.next;
        n.next.prev = n.prev;
      }
      head.next = n;
      n.prev = head;
      head = n;
      return n.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {

    if (get(key) != -1) {
      map.get(key).value = value;
      return;
    }

    if (map.size() >= capacity) {
      map.remove(tail.key);
      tail = tail.next;
      if(tail != null)
      tail.prev = null;
    }
    Node n = new Node(key, value);
    if (tail == null) {
      head = n;
      tail = head;
      tail.prev = null;
    } else {
      n.prev = head;
      head.next = n;
      head = n;
    }
    map.put(key, n);
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(1);
    lRUCache.put(2, 1); // cache is {1=1}
    //lRUCache.put(2, 2); // cache is {1=1, 2=2}
    System.out.println(lRUCache.get(2)); // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    System.out.println(lRUCache.get(2)); // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    System.out.println(lRUCache.get(1)); // return -1 (not found)
    System.out.println(lRUCache.get(3)); // return 3
    System.out.println(lRUCache.get(4)); // return 4
  }
}
