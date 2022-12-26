package com.mali.ds.design;

/* https://leetcode.com/contest/weekly-contest-323/problems/design-memory-allocator/ */
public class DesignMemoryAllocator {

  int[] arr;
  int n;
  int size = 0;

  public DesignMemoryAllocator(int n) {
    arr = new int[n];
    this.n = n;
  }

  public int allocate(int size, int mID) {

    if (this.size + size > n) {
      return -1;
    }

    int start = -1;
    int count = 0;
    int i = 0;
    for (; i < n; i++) {

      if (count == size) {
        break;
      }
      if (arr[i] > 0) {
        count = 0;
        start = i;
      } else {
        count += 1;
      }
    }

    if (count == size) {

      start += 1;
      int ans = start;
      for (i = start; i < start + size; i++) {
        arr[i] = mID;
      }
      this.size += size;
      return ans;
    }
    return -1;
  }

  public int free(int mID) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == mID) {
        arr[i] = -1;
        count += 1;
      }
    }
    size -= count;
    return count;
  }

  public static void main(String[] args) {
    /*DesignMemoryAllocator memoryAllocator = new DesignMemoryAllocator(10);
    System.out.println(memoryAllocator.allocate(1, 1));
    System.out.println(memoryAllocator.allocate(1, 2));
    System.out.println(memoryAllocator.allocate(1, 3));
    System.out.println(memoryAllocator.free(2));
    System.out.println(memoryAllocator.allocate(3, 4));
    System.out.println(memoryAllocator.allocate(1, 1));
    System.out.println(memoryAllocator.allocate(1, 1));
    System.out.println(memoryAllocator.free(1));
    System.out.println(memoryAllocator.allocate(10, 2));
    System.out.println(memoryAllocator.free(7));*/

    DesignMemoryAllocator memoryAllocator = new DesignMemoryAllocator(5);
    System.out.println(memoryAllocator.free(4));
    System.out.println(memoryAllocator.allocate(9, 5));
    System.out.println(memoryAllocator.allocate(5, 8));
    System.out.println(memoryAllocator.allocate(4, 8));
    System.out.println(memoryAllocator.allocate(3, 2));
    System.out.println(memoryAllocator.free(6));
    System.out.println(memoryAllocator.allocate(9, 9));
    System.out.println(memoryAllocator.free(6));
  }
}
