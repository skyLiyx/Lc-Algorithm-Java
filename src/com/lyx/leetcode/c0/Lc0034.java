package com.lyx.leetcode.c0;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 思路：二分查找
 *
 * @version 2023/09/20
 */
public class Lc0034 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        int start = -1, end = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                start = mid;
                end = mid;
                while (start > 0 && nums[start - 1] == target) {
                    start--;
                }
                while (end < nums.length - 1 && nums[end + 1] == target) {
                    end++;
                }
                break;
            }
        }
        return new int[]{start, end};
    }
}
