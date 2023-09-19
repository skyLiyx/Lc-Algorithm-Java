package com.lyx.leetcode;

/**
 * 2560.打家劫舍IV
 *
 * 思路：二分法+贪心
 *
 * @version 2023/09/19
 */
public class Lc2560 {
    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            right = Math.max(num, right);
        }
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mid) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                c++;
                i++;
            }
        }
        return c >= k;
    }
}
