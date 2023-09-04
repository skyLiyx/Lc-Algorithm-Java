package com.lyx.datastruct;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.length() < 2) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        return deserialize(data.split(","), 0);
    }

    private static TreeNode deserialize(String[] data, int i) {
        if (i >= data.length || "null".equals(data[i])) {
            return null;
        }
        return new TreeNode(
                Integer.parseInt(data[i]),
                deserialize(data, i * 2 + 1),
                deserialize(data, i * 2 + 2));
    }
}
