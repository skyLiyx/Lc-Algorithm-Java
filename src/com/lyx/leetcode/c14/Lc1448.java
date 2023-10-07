package com.lyx.leetcode.c14;

import com.lyx.datastruct.TreeNode;

/**
 * 1448.统计二叉树中好结点的数目
 *
 * 思路：深度优先搜索。前序遍历。
 *
 * @version 2023/08/25
 */
public class Lc1448 {

    private int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            max = root.val;
            res += 1;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
