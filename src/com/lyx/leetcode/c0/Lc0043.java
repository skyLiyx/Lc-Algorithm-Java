package com.lyx.leetcode.c0;

/**
 * 43.字符串相乘
 *
 * @version 2023/10/08
 */
public class Lc0043 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int val1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int val2 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + val1 * val2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
