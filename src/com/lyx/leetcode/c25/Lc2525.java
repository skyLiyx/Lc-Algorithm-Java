package com.lyx.leetcode.c25;

/**
 * 2525.根据规则将箱子分类
 */
public class Lc2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        long max = Math.max(length, Math.max(width, height)), vol = (long)length * width * height;
        boolean isBulky = max >= 10000 || vol >= 1000000000, isHeavy = mass >= 100;
        if (isBulky && isHeavy) {
            return "Both";
        } else if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
