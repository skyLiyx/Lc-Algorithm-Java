package com.lyx.leetcode.c7;

/**
 * 765.情侣牵手
 *
 * @version 2023/11/11
 */
public class Lc0765 {
    int[] p = new int[70];

    private void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int m = n >> 1;
        for (int i = 0; i < m; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (i == find(i)) {
                cnt++;
            }
        }
        return m - cnt;
    }
}
