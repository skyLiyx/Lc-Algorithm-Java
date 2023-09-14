package com.lyx.leetcode;

import java.util.*;

/**
 * 1222.可以攻击国王的皇后
 *
 * 思路：枚举
 *
 * @version 2023/09/14
 */
public class Lc1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> qSet = new HashSet<>();
        for (int[] q : queens) {
            qSet.add(Arrays.asList(q[0], q[1]));
        }
        // 从国王位置出发找到符合条件的皇后
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int mi = king[0] + i, mj = king[1] + j;
                while (mi >= 0 && mi < 8 && mj >= 0 && mj < 8) {
                    List<Integer> list = Arrays.asList(mi, mj);
                    if (qSet.contains(list)) {
                        res.add(list);
                        break;
                    }
                    mi += i;
                    mj += j;
                }
            }
        }
        return res;
    }
}
