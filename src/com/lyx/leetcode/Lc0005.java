package com.lyx.leetcode;

/**
 * 5.最长回文子串。
 *
 * 思路：动态规划
 */
public class Lc0005 {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        // 定义dp[i][j]表示从索引i到j的子串是否为回文
        boolean[][] dp = new boolean[ch.length][ch.length];
        int max = 0, left = 0, right = 0;
        for (int j = 1; j < ch.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (ch[i] == ch[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (max < j - i + 1){
                        max = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
