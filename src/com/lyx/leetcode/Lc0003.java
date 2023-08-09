package com.lyx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 思路：滑动窗口
 */
public class Lc0003 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(); // 字符 -> 字符位置
        int max = 0;
        int left = 0;
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                // 窗口左边界移动到第一个位置之后
                left = Math.max(left, map.get(ch[i]) + 1);
            }
            map.put(ch[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
