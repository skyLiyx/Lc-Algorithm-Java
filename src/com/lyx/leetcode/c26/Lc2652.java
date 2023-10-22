package com.lyx.leetcode.c26;

/**
 * 2652.倍数求和
 */
public class Lc2652 {
    public int sumOfMultiples(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7)
                - f(n, 15) - f(n, 21) - f(n, 35) + f(n, 105);
    }

    private int f(int n, int m) {
        return (m + n / m * m) * (n / m) / 2;
    }
}
