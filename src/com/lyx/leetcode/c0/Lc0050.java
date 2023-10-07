package com.lyx.leetcode.c0;

/**
 * 50.Pow(x, n)
 *
 * 思路：二分法
 *
 * @version 2023/08/25
 */
public class Lc0050 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1d;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }
}
