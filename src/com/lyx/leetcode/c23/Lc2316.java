package com.lyx.leetcode.c23;

import com.lyx.datastruct.UnionFindSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 2316.统计无向图中无法互相到达点对数
 */
public class Lc2316 {
    public long countPairs(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        UnionFindSet<Integer> unionFindSet = new UnionFindSet<>(list);
        for (int[] edge : edges) {
            unionFindSet.union(edge[0], edge[1]);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += n - unionFindSet.size(i);
        }
        return res / 2;
    }
}
