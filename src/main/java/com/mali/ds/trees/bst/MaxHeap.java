package com.mali.ds.trees.bst;

public class MaxHeap {

  private int[] heap;
  private int size;
  private int maxSize;

  MaxHeap(int maxSize) {
    this.maxSize = maxSize;
    this.size = 0;
    heap = new int[this.maxSize + 1];
    heap[0] = Integer.MAX_VALUE;
  }

  private int parent(int pos) {
    return pos / 2;
  }

  private int leftChild(int pos) {
    return 2 * pos;
  }

  private int rightChild(int pos) {
    return 2 * pos + 1;
  }

  private boolean isLeaf(int pos) {
    return pos > size / 2 && pos <= size;
  }

  private void swap(int spos, int fpos) {
    int temp = heap[fpos];
    heap[fpos] = heap[spos];
    heap[spos] = temp;
  }

  public void heapify(int pos) {
    if (isLeaf(pos)) {
      return;
    }
    if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
      if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
        swap(pos, leftChild(pos));
        heapify(leftChild(pos));
      } else {
        swap(pos, rightChild(pos));
        heapify(rightChild(pos));
      }
    }
  }

  public void insert(int element) {
    heap[++size] = element;
    int current = size;
    while (heap[parent(current)] < heap[current]) {
      swap(parent(current), current);
      current = parent(current);
    }
  }

  public int poll() {
    int result = heap[1];
    heap[1] = heap[size--];
    heapify(1);
    return result;
  }

  public int peek() {
    return heap[1];
  }

  public static void main(String[] args){
    MaxHeap maxHeap = new MaxHeap(28);
    maxHeap.insert(23);
    System.out.println(maxHeap.peek());
    maxHeap.insert(21);
    System.out.println(maxHeap.peek());
    maxHeap.insert(56);
    System.out.println(maxHeap.peek());
    maxHeap.insert(-1);
    System.out.println(maxHeap.peek());
    maxHeap.insert(0);
    System.out.println(maxHeap.peek());
    maxHeap.insert(2);
    System.out.println(maxHeap.peek());
    maxHeap.insert(33);
    System.out.println(maxHeap.peek());
    maxHeap.insert(98);
    System.out.println(maxHeap.peek());
    maxHeap.insert(99);
    System.out.println(maxHeap.peek());
    maxHeap.poll();
    System.out.println(maxHeap.peek());
  }

}
