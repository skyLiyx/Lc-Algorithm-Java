package com.lyx.leetcode.c2;

/**
 * 260.只出现一次的数字III
 *
 * @version 2023/10/16
 */
public class Lc0260 {
    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        // 两个数字一定至少有一位是不同的
        // 所以找出最右边的1，通过这一位，
        // 可以找出其中一个只出现一次的数
        int rightOne = eor & (~eor + 1);
        int _eor = 0;
        for (int num : nums) {
            if ((num & rightOne) == rightOne) {
                _eor ^= num;
            }
        }
        return new int[]{_eor, _eor ^ eor};
    }
}
