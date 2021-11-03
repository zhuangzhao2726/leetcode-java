package com.zhuangzhao.leetcode.one.four.four;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(4, new TreeNode(5), new TreeNode(6)));
        List<Integer> list = solution.preorderTraversal(root);
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}