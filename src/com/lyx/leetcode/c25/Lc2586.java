package com.lyx.leetcode.c25;

import java.util.Arrays;
import java.util.List;

/**
 * 2586.统计范围内的元音字符串数
 *
 * @version 2023/11/07
 */
public class Lc2586 {
    public int vowelStrings(String[] words, int left, int right) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (list.contains(words[i].charAt(0)) && list.contains(words[i].charAt(words[i].length() - 1))) {
                ans++;
            }
        }
        return ans;
    }
}
