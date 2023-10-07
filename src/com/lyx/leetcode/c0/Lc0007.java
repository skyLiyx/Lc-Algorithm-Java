package com.lyx.leetcode.c0;

/**
 * 7.整数反转
 *
 * 思路：循环收集个位的数，放到收集数的后面，直到收集完
 */
public class Lc0007 {

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return (int)result == result ? (int)result : 0;
    }

}
