package com.lyx.leetcode.c11;

/**
 * 1155.掷骰子等于目标和的方法数
 *
 * @version 2023/10/24
 */
public class Lc1155 {
    private static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        // 定义dp[i][j]表示使用掷i个骰子且数字和为j的方案数目
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                for (int x = 1; x <= k; x++) {
                    if (j >= x) {
                        // 掷i个骰子且数字和为j的方案数目等于
                        // 从掷i-1个骰子且数字和为j-1
                        // 到掷i-1个骰子且数字和为j-k的数目总和
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
