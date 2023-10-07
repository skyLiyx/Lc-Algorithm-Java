package com.lyx.leetcode.c1;

/**
 * 198.打家劫舍
 *
 * 思路：动态规划
 *
 * @version 2023/09/16
 */
public class Lc0198 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 第一个房子处最大的偷窃金额
        int pre2 = nums[0];
        // 第二个房子处最大的偷窃金额
        int pre1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // 对于每座房子仅有两种状态：偷与不偷
            // 偷：偷上上个的最大值+当前值
            // 不偷：偷上一个的最大值
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
