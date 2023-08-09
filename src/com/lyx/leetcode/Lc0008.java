package com.lyx.leetcode;

/**
 * 8.字符串转换整数 (atoi)
 *
 * 思路1：按题目要求一步步来
 * 思路2：正则匹配
 */
public class Lc0008 {

    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        long result = 0;
        boolean positive = true;
        boolean beyond = false;
        int index = 0;
        for (char c : ch) {
            if (index > 0 && (c < '0' || c > '9')) {
                break;
            }
            if (index == 0) {
                if (c == ' ') {
                    continue;
                } else if (c == '+') {
                    index++;
                } else if (c == '-') {
                    positive = false;
                    index++;
                } else if (c < '0' || c > '9') {
                    break;
                }
            }
            if (c >= '0' && c <= '9') {
                result = result * 10 + (c - '0');
                index++;
            }
            if (positive && result > Integer.MAX_VALUE || (!positive && result > 1L + Integer.MAX_VALUE)) {
                beyond = true;
                break;
            }
        }
        if (beyond) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return positive ? (int)result : (int)-result;
    }

}
