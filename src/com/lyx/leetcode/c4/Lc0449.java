package com.lyx.leetcode.c4;

import com.lyx.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 449.序列化和反序列化二叉搜索树
 *
 * 思路：后序遍历
 *
 * @version 2023/09/04
 */
public class Lc0449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(", ");
        Stack<Integer> stack = new Stack<>();
        for (String s : arr) {
            stack.push(Integer.parseInt(s));
        }
        return deserialize(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    private TreeNode deserialize(int lower, int upper, Stack<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        int val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right = deserialize(val, upper, stack);
        root.left = deserialize(lower, val, stack);
        return root;
    }
}
