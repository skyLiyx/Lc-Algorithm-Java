package com.lyx.leetcode.c25;

/**
 * 2511.最多可以摧毁的敌人城堡数目
 *
 * 思路：暴力枚举
 *
 * @version 2023/09/02
 */
public class Lc2511 {
    public int captureForts(int[] forts) {
        // 移动标记
        boolean flag = false;
        // 顺序标记，1->-1为true
        boolean order = true;
        // 移动起始索引
        int start = -1;
        // 最多摧毁数目
        int res = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (!flag) {
                    // 未移动，更新开始移动标记，顺序标记
                    flag = true;
                    order = forts[i] == 1;
                } else if ((order && forts[i] == -1) || (!order && forts[i] == 1)) {
                    // 移动摧毁完毕，更新最大摧毁数目，同时顺序置反
                    res = Math.max(res, i - start - 1);
                    order = !order;
                }
                // 更新移动起始位置
                start = i;
            }
        }
        return res;
    }
}
