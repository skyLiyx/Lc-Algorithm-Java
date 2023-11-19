package com.lyx.leetcode.c20;

import java.util.*;

/**
 * 2003.每棵子树内缺失的最小基因值
 *
 * @version 2023/10/31
 */
public class Lc2003 {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                node = i;
                break;
            }
        }
        if (node < 0) {
            return ans;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parents[i]].add(i);
        }
        Set<Integer> set = new HashSet<>();
        int m = 2;
        while (node >= 0) {
            dfs(node, g, set, nums);
            while (set.contains(m)) {
                m++;
            }
            ans[node] = m;
            node = parents[node];
        }
        return ans;
    }

    private void dfs(int x, List<Integer>[] g, Set<Integer> set, int[] nums) {
        set.add(nums[x]);
        for (int son : g[x]) {
            if (!set.contains(nums[son])) {
                dfs(son, g, set, nums);
            }
        }
    }
}
