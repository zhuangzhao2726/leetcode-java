package com.zhuangzhao.leetcode.six.eight.seven;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public int longestUnivaluePath(TreeNode root) {
        TreeNode head = new TreeNode(0);
        search(root, head);
        return searchMax(head);
    }

    private int searchMax(TreeNode head) {
        if(head != null) {
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;
            if(head.left != null) {
                leftMax = searchMax(head.left);
            }
            if(head.right != null){
                rightMax = searchMax(head.right);
            }
            return maxNum(head.val, leftMax, rightMax);
        }
        return 0;
    }

    private int maxNum(int val1, int val2, int val3) {

        int leftMax = val1 > val2 ? val1 : val2;
        int rightMax = val2 > val3 ? val2 : val3;
        return leftMax > rightMax ? leftMax : rightMax;
    }

    private void search(TreeNode root, TreeNode node) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null){
            node.val = 0;
        } else if(root.left == null) {
            node.right = new TreeNode(0);
            search(root.right, node.right);
            if (root.val == root.right.val) {
                node.val = node.right.val + 1;
            }
        } else if(root.right == null) {
            node.left = new TreeNode(0);
            search(root.left, node.left);
            if (root.val == root.left.val) {
                node.val = node.left.val + 1;
            }
        } else {
            node.left = new TreeNode(0);
            node.right = new TreeNode(0);
            search(root.left, node.left);
            search(root.right, node.right);

            if(root.val == root.left.val && root.val == root.right.val) {
                node.val = 1 + node.left.val > node.right.val ? node.left.val : node.right.val;
            } else if(root.val == root.left.val) {
                node.val = 1 + node.left.val;
            } else if(root.val == root.right.val) {
                node.val = 1 + node.right.val;
            }
        }
    }
}