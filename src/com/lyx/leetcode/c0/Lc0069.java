package com.lyx.leetcode.c0;

/**
 * 69.x的平方根
 *
 * 思路：二分查找/牛顿迭代
 *
 * @version 2023/09/20
 */
public class Lc0069 {
    /**
     * 二分查找
     */
    public int mySqrt(int x) {
        int res = -1;
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long d = (long)mid * mid;
            if (x >= d) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代
     */
    public int mySqrt_1(int x) {
        if (x == 0) {
            return 0;
        }
        double x0 = x;
        double e = 1e-7; // 精确值，10的-7次方
        while (true) {
            double xi = (x0 + x / x0) / 2;
            if (Math.abs(x0 - xi) < e) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}
