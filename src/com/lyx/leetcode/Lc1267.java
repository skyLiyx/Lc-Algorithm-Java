package com.lyx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1267.统计参与通信的服务器
 *
 * 思路：遍历+哈希
 * 时间复杂度：O(mn)
 *
 * @version 2023/08/24
 */
public class Lc1267 {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 当前行的服务器数量加1
                    rows.put(i, rows.getOrDefault(i, 0) + 1);
                    // 当前列的服务器数量加1
                    cols.put(j, cols.getOrDefault(j, 0) + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前行或当前列服务器数量大于1，那么就可以通信
                if (grid[i][j] == 1 && (rows.get(i) > 1 || cols.get(j) > 1)) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
