package com.lyx.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 2603.收集树中金币
 *
 * 思路：拓扑排序
 *
 * @version 2023/09/21
 */
public class Lc2603 {
    public int collectCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        // 构造图
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
            degree[x]++;
            degree[y]++;
        }
        int rest = n - 1;
        // 删除树中所有无金币的叶子节点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            rest--;
            for (int y : g[x]) {
                degree[y]--;
                if (degree[y] == 1 && coins[y] == 0) {
                    queue.offer(y);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 1) {
                queue.offer(i);
            }
        }
        rest -= queue.size();
        for (int x : queue) {
            for (int y : g[x]) {
                if (--degree[y] == 1) {
                    rest--;
                }
            }
        }
        return Math.max(rest * 2, 0);
    }
}
