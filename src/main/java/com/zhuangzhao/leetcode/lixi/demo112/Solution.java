package com.zhuangzhao.leetcode.lixi.demo112;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left != null) {
            if (hasPathSum(root.left, targetSum - root.val)) {
                return true;
            }
        }
        if (root.right != null) {
            if (hasPathSum(root.right, targetSum - root.val)) {
                return true;
            }
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1))));
        Solution solution = new Solution();
        boolean hasPathSum = solution.hasPathSum(treeNode, 22);
    }
}