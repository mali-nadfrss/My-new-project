package com.mali.ds.linkedList;

/* https://leetcode.com/problems/design-browser-history/
 * medium */
public class DesignBrowserHistory {

  class DoubleLinkedList {

    String data;
    DoubleLinkedList prev;
    DoubleLinkedList next;

    DoubleLinkedList(String data) {
      this.data = data;
    }
  }

  DoubleLinkedList head;

  public DesignBrowserHistory(String homepage) {
    head = new DoubleLinkedList(homepage);
  }

  public void visit(String url) {
    if (url.equals(head.data)) {
      return;
    }
    DoubleLinkedList d = new DoubleLinkedList(url);
    head.next = d;
    d.prev = head;
    head = d;
  }

  public String back(int steps) {
    int c = steps;
    while (head.prev != null) {
      head = head.prev;
      c--;
      if (c == 0) break;
    }
    return head.data;
  }

  public String forward(int steps) {
    int c = steps;
    while (head.next != null) {
      head = head.next;
      c--;
      if (c == 0) break;
    }
    return head.data;
  }

  public static void main(String[] args) {

    DesignBrowserHistory history = new DesignBrowserHistory("l");
    history.visit("g");
    history.visit("f");
    history.visit("y");
    System.out.println(history.back(1));
    System.out.println(history.back(1));
    System.out.println(history.forward(1));
    history.visit("lin");
    System.out.println(history.forward(2));
    System.out.println(history.back(2));
    System.out.println(history.back(7));
  }
}
