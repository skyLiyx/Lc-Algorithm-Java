package com.lyx.leetcode.c0;

import java.util.HashMap;
import java.util.Map;

/**
 * 13.罗马数字转整数。
 *
 * 思路：穷举
 */
public class Lc0013 {

    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    public int romanToInt(String s) {
        if (s.length() == 1) return map.get(s);
        int index = 0;
        int res = 0;
        while (index < s.length()) {
            if (index < s.length() - 1 && map.containsKey(s.substring(index, index + 2))) {
                res += map.get(s.substring(index, index + 2));
                index += 2;
            } else {
                res += map.get(s.substring(index, index + 1));
                index += 1;
            }
        }
        return res;
    }

}
