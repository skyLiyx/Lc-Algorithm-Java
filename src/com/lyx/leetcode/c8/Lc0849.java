package com.lyx.leetcode.c8;

/**
 * 849.到最近的人的最大距离
 *
 * 解法：双指针
 */
public class Lc0849 {
    public int maxDistToClosest(int[] seats) {
        // 至少距离1
        int maxDist = 1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                continue;
            }
            int j = i + 1, curDist = 1;
            while (j < seats.length && seats[j] == 0) {
                curDist += 1;
                j += 1;
            }
            if (i == 0 || j == seats.length) {
                // 在两边时，最大距离就是0的数量
                maxDist = Math.max(maxDist, curDist);
                if (j == seats.length) {
                    break;
                }
            } else {
                // 不在两边时，最大距离取对半
                maxDist = Math.max(maxDist, (curDist + 1) >> 1);
            }
        }
        return maxDist;
    }
}
