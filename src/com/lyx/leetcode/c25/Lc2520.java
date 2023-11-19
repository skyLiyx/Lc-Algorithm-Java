package com.lyx.leetcode.c25;

/**
 * 2520.统计能整除数字的位数
 *
 * @version 2023/10/26
 */
public class Lc2520 {
    public int countDigits(int num) {
        if (num < 11) {
            return 1;
        }
        int ans = 0;
        int cur = num;
        while (cur > 0) {
            if (num % (cur % 10) == 0) {
                ans++;
            }
            cur /= 10;
        }
        return ans;
    }
}
