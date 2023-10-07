package com.lyx.leetcode.c25;

import java.util.Arrays;

/**
 * 2594.修车的最少时间
 *
 * 思路：二分法
 *
 * @version 2023/09/07
 */
public class Lc2594 {
    public long repairCars(int[] ranks, int cars) {
        // 已知最少需要时间为1分钟，最多需要时间为将所有车都
        // 交给其中某一个机械工修理的时间，最多需要时间存在一
        // 个最小值，为能力最小值机械工修完所有车的时间，所以
        // 在这个时间范围内采用二分法求出
        Arrays.sort(ranks);
        long l = 1, r = ranks[0] * cars * cars;
        while (l < r) {
            long m = l + ((r - l) >> 1);
            if (check(ranks, cars, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean check(int[] ranks, int cars, long m) {
        int count = 0;
        for (int rank : ranks) {
            count += Math.sqrt(m / rank);
        }
        return count >= cars;
    }
}
