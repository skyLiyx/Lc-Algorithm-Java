package com.lyx.leetcode;

/**
 * 合并两个有序数组。
 *
 * 思路：插入排序。
 */
public class Lc0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        for (int i = m - 1, j = 0; i < m + n - 1; i++, j++) {
            int k = i;
            while (k >= 0 && nums1[k] > nums2[j]) {
                nums1[k + 1] = nums1[k];
                k--;
            }
            nums1[k + 1] = nums2[j];
        }
    }

}
