package com.lyx.leetcode.c14;

import java.util.Arrays;

/**
 * 1402.做菜顺序
 *
 * 思路：贪心
 */
public class Lc1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int p = -1;
        for (int i = 0; i < satisfaction.length; i++) {
            if (satisfaction[i] < 0) {
                p = i;
            } else {
                break;
            }
        }
        if (p == satisfaction.length - 1) {
            return 0;
        }
        if (p == -1) {
            return getTotalLikeTime(satisfaction, 0);
        }
        // 当前指针的值与当前指针之后的数值和的和大于0，即可指针左移
        while (p >= 0 && check(satisfaction, p)) {
            p--;
        }
        return getTotalLikeTime(satisfaction, p + 1);
    }

    private boolean check(int[] satisfaction, int p) {
        int sum = 0;
        for (int i = p + 1; i < satisfaction.length; i++) {
            sum += satisfaction[i];
        }
        return -satisfaction[p] < sum;
    }

    private int getTotalLikeTime(int[] satisfaction, int start) {
        int res = 0, time = 1;
        for (int i = start; i < satisfaction.length; i++, time++) {
            res += satisfaction[i] * time;
        }
        return res;
    }
}