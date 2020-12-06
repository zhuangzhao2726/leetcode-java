package com.zhuangzhao.leetcode.interview.one;


/**
 * Definition for a binary tree node.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int maxAncestorDiff(TreeNode root) {


        TreeNode head = new TreeNode(root.val);
        copyTree(root, head);
        behindScan(head);
        int max = behindSearch(root, head);
        return max;
    }

    private int behindSearch(TreeNode root, TreeNode head) {
        if(root == null) {
            return Integer.MIN_VALUE;
        } else {
            if(root.left == null && root.right == null) {
                return (root.val - head.val);
            } else if(root.left == null) {
                int val = behindSearch(root.right, head.right);
                return val > (root.val - head.val) ? val : (root.val - head.val);
            } else if(root.right == null) {
                int val = behindSearch(root.left, head.left);
                return val > (root.val - head.val) ? val : (root.val - head.val);
            } else {
                int leftVal = behindSearch(root.left, head.left);
                int rightVal = behindSearch(root.right, head.right);
                int val = leftVal > rightVal ? leftVal : rightVal;
                return val > (root.val - head.val) ? val : (root.val - head.val);
            }
        }
    }

    private int behindScan(TreeNode head) {
        if(head != null) {
            if(head.left == null && head.right == null) {
                return head.val;
            } else if(head.left == null) {
                int val = behindScan(head.right);
                if(val < head.val) {
                    head.val = val;
                }
                return head.val;
            } else if(head.right == null) {
                int val = behindScan(head.left);
                if(val < head.val) {
                    head.val = val;
                }
                return head.val;
            } else {
                int leftVal = behindScan(head.left);
                int rightVal = behindScan(head.right);
                int val = leftVal < rightVal ? leftVal : rightVal;
                if(val < head.val) {
                    head.val = val;
                }
                return head.val;
            }
        }
        return Integer.MAX_VALUE;
    }

    private void copyTree(TreeNode root, TreeNode head) {
        if(root != null) {
            if(root.left != null) {
                head.left = new TreeNode(root.left.val);
                copyTree(root.left, head.left);
            }
            if(root.right != null) {
                head.right = new TreeNode(root.right.val);
                copyTree(root.right, head.right);
            }
        }
    }
}