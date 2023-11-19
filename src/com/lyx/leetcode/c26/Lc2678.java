package com.lyx.leetcode.c26;

/**
 * 2678.老人的数目
 *
 * @version 2023/10/23
 */
public class Lc2678 {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String s : details) {
            if (s.charAt(11) == '6' && s.charAt(12) > '0' || s.charAt(11) > '6') {
                res++;
            }
        }
        return res;
    }
}
