package com.zhuangzhao.leetcode.interview_internal_reference.three;


/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-10-05 00:33
 */
public class Solution {


    public TreeNode findKthNode(TreeNode root, int k) {
        Result result = searchTreeNode(root, 0, k);
        return result.node;
    }


    public Result searchTreeNode(TreeNode node, int index, int k) {
        if (node == null) {
            return new Result(false,  index - 1, null);
        }
        Result result01 = searchTreeNode(node.left, index, k);
        if (result01.found) {
            return result01;
        }
        index = result01.index +1;
        if (index == k)  {
            return new Result(true, index, node);
        }
        return searchTreeNode(node.right, index + 1, k);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        System.out.println(solution.findKthNode(root, 0));
        System.out.println(solution.findKthNode(root, 1));
        System.out.println(solution.findKthNode(root, 2));
        System.out.println(solution.findKthNode(root, 3));
        System.out.println(solution.findKthNode(root, 4));
        System.out.println(solution.findKthNode(root, 5));
        System.out.println(solution.findKthNode(root, 6));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

class Result {
    boolean found;
    int index;
    TreeNode node;


    public Result(boolean found, int index, TreeNode node) {
        this.found = found;
        this.index = index;
        this.node = node;
    }
}