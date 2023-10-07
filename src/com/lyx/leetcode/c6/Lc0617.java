package com.lyx.leetcode.c6;

import com.lyx.datastruct.TreeNode;

/**
 * 617.合并二叉树
 *
 * 思路：深度优先搜索
 */
public class Lc0617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode mergedTreeNode = new TreeNode(root1.val + root2.val);
        mergedTreeNode.left = mergeTrees(root1.left, root2.left);
        mergedTreeNode.right = mergeTrees(root1.right, root2.right);
        return mergedTreeNode;
    }
}
