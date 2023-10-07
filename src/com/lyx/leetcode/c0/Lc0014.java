package com.lyx.leetcode.c0;

import java.util.Arrays;

/**
 * 14.最长公共前缀。
 *
 * 思路：以第一个为基准迭代查询，遇到没有公共前缀的提前返回。
 */
public class Lc0014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        char[] res = strs[0].toCharArray();
        for (int i = 1; i < strs.length; i++) {
            char[] cur = strs[i].toCharArray();
            int index = 0;
            while (index < res.length && index < cur.length && res[index] == cur[index]) {
                index++;
            }
            if (index == 0) return "";
            res = Arrays.copyOfRange(res, 0, index);
        }
        return new String(res);
    }

}
