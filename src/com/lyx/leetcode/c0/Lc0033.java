package com.lyx.leetcode.c0;

/**
 * 33.搜索旋转排序数组
 *
 * 思路：二分查找
 *
 * @version 2023/09/20
 */
public class Lc0033 {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                // 如果中点落在k点右边，目标值在k点和中点之间
                // 否则目标值在中点左边或k点右边
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                } else if (target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 如果中点落在k点左边，目标值在中点和k点之间
                // 否则目标值在k点左边或中点右边
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
