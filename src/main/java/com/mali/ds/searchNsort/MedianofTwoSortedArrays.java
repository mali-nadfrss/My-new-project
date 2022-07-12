package com.mali.ds.searchNsort;

/* https://leetcode.com/problems/median-of-two-sorted-arrays/
 * hard */
public class MedianofTwoSortedArrays {

  /* normally median is mid number in case of odd len or sum of mid /2 in case of even len
  if we have
  * 1 3 5 7
  * 2 4 6 8
  * make a cut at mid will give 1 3(L1)   (R1)5 7
  *                             2 4(L2)    (R2)6 8
  * if we can make sure that   L1 < R1 && L1 < R2 && l2 < R2 && L2 < R1
  * i.e. all elements in lower half are less than all elements in higher halfs median is nothing but (max(L1,L2)+ min(R1,R2)/2   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int N1 = nums1.length;
    int N2 = nums2.length;

    int low = 0;
    int high = N2 * 2;

    while (low <= high) {
      int mid1 = low + (high - low) / 2;
      int mid2 = N1 + N2 - mid1;
      double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
      double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
      double R1 = (mid1 == N1) ? Integer.MAX_VALUE : nums1[mid1 / 2];
      double R2 = (mid2 == N2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

      if (L1 > R2) low = mid1 + 1;
      else if (L2 > R1) high = mid1 - 1;
      else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
    }
    return -1;
  }
}
