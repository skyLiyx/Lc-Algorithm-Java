package com.lyx.leetcode;

/**
 * 6.N字形变换
 *
 * 思路：找规律
 */
public class Lc0006 {

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[] ch = s.toCharArray();
        // N字形之间处于相同位置的字符的间隔，即N字形的大小
        int interval = (numRows << 1) - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            // 每层第一个字符的位置
            int firstIndex = i;
            // 第二个字符的位置（中间层才有）
            int secondIndex = interval - firstIndex;
            while (firstIndex < ch.length) {
                sb.append(ch[firstIndex]);
                firstIndex += interval;
                if (i != 0 && i != numRows - 1 && secondIndex < ch.length) {
                    sb.append(ch[secondIndex]);
                    secondIndex += interval;
                }
            }
        }
        return sb.toString();
    }

}
