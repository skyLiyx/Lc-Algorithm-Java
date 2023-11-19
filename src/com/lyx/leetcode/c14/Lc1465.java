package com.lyx.leetcode.c14;

import java.util.Arrays;

/**
 * 1465.切割后面积最大的蛋糕
 *
 * @version 2023/10/27
 */
public class Lc1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hl = horizontalCuts.length;
        int vl = verticalCuts.length;
        // 水平最大间距
        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[hl - 1]);
        for (int i = 1; i < hl; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        // 垂直最大间距
        int maxV = Math.max(verticalCuts[0], w - verticalCuts[vl - 1]);
        for (int i = 1; i < vl; i++) {
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int)((long)maxH * maxV % 1000000007);
    }
}
