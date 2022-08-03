package com.mali.ds.design;

import java.util.*;

/* https://leetcode.com/problems/lru-cache/
 * medium */
/* Use Doubly linked List to get O(1) time for all operations */
public class LRUCache {

  int capacity;
  DoublyLinkedList tail;
  DoublyLinkedList head;

  class DoublyLinkedList {

    int value;
    int key;

    DoublyLinkedList prev;
    DoublyLinkedList next;

    DoublyLinkedList(int value, int key) {
      this.value = value;
      this.key = key;
    }

    void remove(DoublyLinkedList node) {
      DoublyLinkedList prev = node.prev;
      DoublyLinkedList next = node.next;
      if (prev != null) {
        prev.next = next;
      }
      if (next != null) {
        next.prev = prev;
      }
      node.next = null;
    }
  }

  Map<Integer, DoublyLinkedList> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
  }

  public int get(int key) {
    DoublyLinkedList node = map.get(key);
    if (node != null) {
      if (head != node) {
        node.remove(node);
        head.next = node;
        node.prev = head;
        head = node;
      }
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.get(key) != null) {
      return;
    }
    if (map.size() >= capacity) {
      DoublyLinkedList temp = tail;
      tail = tail.next;
      tail.prev = null;
      map.remove(temp.key);
    }
    DoublyLinkedList node = new DoublyLinkedList(value, key);
    if (map.size() == 0) {
      tail = head = node;
      tail.prev = null;
    } else {
      DoublyLinkedList cur = head;
      head = node;
      cur.next = node;
      node.prev = cur;
      node.next = null;
    }
    map.put(key, node);
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    System.out.println(lRUCache.get(1)); // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    System.out.println(lRUCache.get(2)); // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    System.out.println(lRUCache.get(1)); // return -1 (not found)
    System.out.println(lRUCache.get(3)); // return 3
    System.out.println(lRUCache.get(4)); // return 4
  }
}
