package com.lyx.leetcode.c0;

/**
 * 35. 搜索插入位置
 *
 * 思路：二分查找
 *
 * @version 2023/09/20
 */
public class Lc0035 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return right;
    }
}
