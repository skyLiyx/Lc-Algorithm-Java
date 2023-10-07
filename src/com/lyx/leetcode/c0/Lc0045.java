package com.lyx.leetcode.c0;

/**
 * 45.跳跃游戏II
 *
 * 思路：贪心
 *
 * @version 2023/09/12
 */
public class Lc0045 {
    public int jump(int[] nums) {
        int res = 0;
        if (nums.length == 1) {
            return res;
        }
        for (int pos = 0; pos < nums.length; ) {
            res += 1;
            if (nums[pos] + pos >= nums.length - 1) {
                break;
            }
            int jump = 0, s = 0, max = Integer.MIN_VALUE;
            for (int i = nums[pos]; i >= 1; i--, s++) {
                if (max < nums[i + pos] - s) {
                    jump = i;
                    max = nums[i + pos] - s;
                }
            }
            pos += jump;
        }
        return res;
    }
}
