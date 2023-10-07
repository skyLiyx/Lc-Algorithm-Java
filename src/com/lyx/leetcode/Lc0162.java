package com.lyx.leetcode;

/**
 * 162.寻找峰值
 *
 * 思路：二分查找
 *
 * @version 2023/09/24
 */
public class Lc0162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
