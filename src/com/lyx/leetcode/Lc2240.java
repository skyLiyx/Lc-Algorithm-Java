package com.lyx.leetcode;

/**
 * 2240.买钢笔和铅笔的方案数
 *
 * 思路：枚举
 *
 * @version 2023/09/01
 */
public class Lc2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 < cost2) {
            // 减少循环计算次数
            return waysToBuyPensPencils(total, cost2, cost1);
        }
        long res = 0, count = 0;
        while (count * cost1 <= total) {
            // 需要加上不买cost2的一次
            res += (total - cost1 * count) / cost2 + 1;
            count++;
        }
        return res;
    }
}
