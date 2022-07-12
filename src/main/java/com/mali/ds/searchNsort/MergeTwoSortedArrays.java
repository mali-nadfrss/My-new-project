package com.mali.ds.searchNsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
 * medium
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/ */
public class MergeTwoSortedArrays {

  static void swap(int i, int j, int[] arr1, int[] arr2) {
    int temp = arr1[i];
    arr1[i] = arr2[j];
    arr2[j] = temp;
  }

  static class Record {
    int array;
    int value;

    public Record(int array, int value) {
      this.array = array;
      this.value = value;
    }
  }

  static int[] mergeKSortedArrays(int[][] arrs) {

    PriorityQueue<Record> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

    ArrayList<Integer> list = new ArrayList<>();
    int[] lens = new int[arrs.length];
    for (int j = 0; j < arrs.length; j++) {
      Record record = new Record(j, arrs[j][0]);
      pq.add(record);
    }

    while (!pq.isEmpty()) {
      Record record = pq.remove();
      list.add(record.value);
      lens[record.array] = lens[record.array] + 1;
      if (lens[record.array] < arrs[0].length) {
        record = new Record(record.array, arrs[record.array][lens[record.array]]);
        pq.add(record);
      }
    }
    return new int[5];
  }

  static void mergeGapTechnic() {

    int[] arr2 = {1, 7, 12, 30};
    int[] arr1 = {2, 4, 6, 67};

    int gap = (int) Math.ceil((float) (arr1.length + arr2.length) / 2);
    while (gap > 0) {
      int i = 0;
      int j = i + gap;
      while (j < (arr1.length + arr2.length)) {
        if (i < arr1.length && j < arr1.length) {
          if (arr1[i] > arr1[j]) {
            swap(i, j, arr1, arr1);
          }
        } else if (i < arr1.length) {
          if (arr1[i] > arr2[j - arr1.length]) {
            swap(i, j - arr1.length, arr1, arr2);
          }
        } else if (arr1[i - arr1.length] > arr2[j - arr1.length]) {
          swap(i - arr1.length, j - arr1.length, arr2, arr2);
        }
        i++;
        j++;
      }
      gap = gap / 2;
    }

    System.out.println(arr1);
    System.out.println(arr2);
  }

  static void mergeSortedArraysNaive() {

    int[] arr2 = {1, 3, 5, 7};
    int[] arr1 = {2, 4, 6, 8};

    int len1 = arr1.length;

    // O(nlog(n)*m) --> O(m*n)
    for (int i = 0; i < len1; i++) {
      if (arr1[i] > arr2[0]) {
        int temp = arr1[i];
        arr1[i] = arr2[0];
        arr2[0] = temp;
      }
      Arrays.sort(arr2);
    }

    System.out.println(arr1);
    System.out.println(arr2);
  }

  public static void main(String[] args) {
    int[] nums1 = {0};
    int m = 0;
    int[] nums2 = {1};
    int n = 1;
    merge(nums1, m, nums2, n);
    mergeSortedArraysNaive();
    mergeGapTechnic();
    int arr[][] = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
    mergeKSortedArrays(arr);
  }

  /* https://leetcode.com/problems/merge-sorted-array/ */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {

    int j = 0;
    if (m == 0) {
      nums1 = nums2;
    }

    for (int i = 0; i < m; i++) {
      if (i < n) {
        if (nums1[i] > nums2[j]) {
          int temp = nums1[i];
          nums1[i] = nums2[j];
          nums2[j] = temp;
        }
      } else {
        nums1[i] = nums2[j];
        j++;
      }
    }
    System.out.println(nums1);
  }
}
