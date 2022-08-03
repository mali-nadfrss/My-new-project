package com.mali.ds.design;

/* https://leetcode.com/problems/design-circular-deque/
 * medium */
public class DesignCircularDeque {
  int size;
  int curSize = 0;
  Node front;
  Node last;

  class Node {

    int value;
    Node next;
    Node prev;

    Node(int value) {
      this.value = value;
    }
  }

  public DesignCircularDeque(int k) {
    this.size = k;
  }

  public boolean insertFront(int value) {
    if (curSize == size) {
      return false;
    }
    Node n = new Node(value);

    if (curSize == 0) {
      last = n;
      front = n;
    } else {

      front.next = n;
      n.prev = front;
      front = n;
    }
    curSize++;
    return true;
  }

  public boolean insertLast(int value) {
    if (curSize == size) {
      return false;
    }
    Node n = new Node(value);
    if (curSize == 0) {
      last = n;
      front = n;
    } else {
      last.prev = n;
      n.next = last;
      last = n;
    }
    curSize++;
    return true;
  }

  public boolean deleteFront() {

    if (curSize == 0) {
      return false;
    }
    if (curSize == 1) {
      last = null;
      front = null;
    } else {
      Node n = front.prev;
      n.next = null;
      front = n;
    }
    curSize -= 1;
    return true;
  }

  public boolean deleteLast() {
    if (curSize == 0) {
      return false;
    }
    if (curSize == 1) {
      last = null;
      front = null;
    } else {
      Node n = last.next;
      last = n;
      last.prev = null;
    }
    curSize -= 1;
    return true;
  }

  public int getFront() {
    return front.value;
  }

  public int getRear() {
    return last.value;
  }

  public boolean isEmpty() {

    return curSize == 0;
  }

  public boolean isFull() {
    return size == curSize;
  }

  // Your MyCircularDeque object will be instantiated and called as such:

  public static void main(String args[]) {
    DesignCircularDeque obj = new DesignCircularDeque(5);
    boolean param_1 = obj.insertFront(7);
    boolean param_2 = obj.insertLast(0);
    int param_3 = obj.getFront();
    boolean param_4 = obj.insertLast(3);
    int param_5 = obj.getFront();
    boolean param_6 = obj.insertFront(9);
    int param_7 = obj.getRear();
    boolean param_8 = obj.deleteLast();
    int param_9 = obj.getRear();
  }
}
