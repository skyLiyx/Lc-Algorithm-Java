package com.lyx.leetcode;

import java.math.BigInteger;

/**
 * 69.x的平方根
 *
 * 思路：二分查找
 *
 * @version 2023/09/20
 */
public class Lc0069 {
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
}
