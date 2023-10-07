package com.lyx.leetcode.c1;

/**
 * 136.只出现一次的数字
 *
 * 思路：位运算
 *
 * @version 2023/09/04
 */
public class Lc0136 {
    public int singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
