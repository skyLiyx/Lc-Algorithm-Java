package com.lyx.leetcode.c26;

/**
 * 2698.求一个整数的惩罚数
 *
 * @version 2023/10/25
 */
public class Lc2698 {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int x = i * i;
            if (backtrace(String.valueOf(x), 0, 0, i)) {
                res += x;
            }
        }
        return res;
    }

    private boolean backtrace(String s, int pos, int total, int target) {
        if (pos == s.length()) {
            return total == target;
        }
        int sum = 0;
        for (int i = pos; i < s.length(); i++) {
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum + total > target) {
                break;
            }
            if (backtrace(s, i + 1, total + sum, target)) {
                return true;
            }
        }
        return false;
    }
}
