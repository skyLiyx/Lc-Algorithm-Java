package com.lyx.leetcode;

/**
 * 213.打家劫舍II
 *
 * 思路：动态规划
 *
 * @version 2023/09/17
 */
public class Lc0213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 偷第一家，不偷最后一家
        int res1 = rob(nums, 0, nums.length - 1);
        // 不偷第一家，偷最后一家
        int res2 = rob(nums, 1, nums.length);

        return Math.max(res1, res2);
    }

    public int rob(int[] nums, int first, int last) {
        int pre1 = nums[first], pre2 = Math.max(nums[first], nums[first + 1]);
        for (int i = first + 2; i < last; i++) {
            int cur = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}
