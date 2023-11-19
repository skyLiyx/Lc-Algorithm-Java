package com.lyx.leetcode.c3;

import java.util.*;

/**
 * 318.最大单词长度乘积
 *
 * @version 2023/11/06
 */
public class Lc0318 {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            if (word.length() > map.getOrDefault(mask, 0)) {
                map.put(mask, word.length());
            }
        }
        int ans = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int len1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int len2 = map.get(mask2);
                    ans = Math.max(ans, len1 * len2);
                }
            }
        }
        return ans;
    }
}
