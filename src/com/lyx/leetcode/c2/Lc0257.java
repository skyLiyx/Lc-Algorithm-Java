package com.lyx.leetcode.c2;

import com.lyx.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257.二叉树的所有路径
 *
 * 思路：回溯/深度优先搜索
 *
 * @version 2023/09/11
 */
public class Lc0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, List<String> list, List<String> res) {
        if (root == null) {
            return;
        }
        list.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", list));
        }
        dfs(root.left, list, res);
        dfs(root.right, list, res);
        list.remove(list.size() - 1);
    }
}
