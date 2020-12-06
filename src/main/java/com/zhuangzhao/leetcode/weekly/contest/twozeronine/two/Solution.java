package com.zhuangzhao.leetcode.weekly.contest.twozeronine.two;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        return isEvenOddTree(treeNodes, true);
    }

    public boolean isEvenOddTree(List<TreeNode> treeNodes, boolean requreEven) {
        boolean pass = false;
        if (requreEven) {
            pass =  checkEven(treeNodes);
        } else {
            pass = checkOdd(treeNodes);
        }
        List<TreeNode> sonNodes = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode != null) {
                if (treeNode.left != null) {
                    sonNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    sonNodes.add(treeNode.right);
                }
            }
        }
        if (sonNodes.isEmpty()) {
            return pass;
        } else {
            return pass && isEvenOddTree(sonNodes, !requreEven);
        }
    }


    public boolean checkEven(List<TreeNode> treeNodes) {
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < treeNodes.size(); i++) {
            if (treeNodes.get(i) != null) {
                 if (treeNodes.get(i).val %2 != 1) {
                     return false;
                 }
                if (treeNodes.get(i).val <= min) {
                    return false;
                }
                min = treeNodes.get(i).val;
            }
        }
        return true;
    }

    public boolean checkOdd(List<TreeNode> treeNodes) {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < treeNodes.size(); i++) {
            if (treeNodes.get(i) != null) {
                if (treeNodes.get(i).val %2 != 0) {
                    return false;
                }
                if (treeNodes.get(i).val >= max) {
                    return false;
                }
                max = treeNodes.get(i).val;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        TreeNode treeNode3 = new TreeNode(3, new TreeNode(12), new TreeNode(8));
        TreeNode treeNode7 = new TreeNode(7, new TreeNode(6), null);
        TreeNode treeNode9 = new TreeNode(9, null, new TreeNode(2));
        TreeNode treeNode10 = new TreeNode(10, treeNode3, null);
        TreeNode treeNode4 = new TreeNode(4, treeNode7, treeNode9);
        TreeNode root = new TreeNode(1, treeNode10, treeNode4);


        Solution solution = new Solution();
        System.out.println(solution.isEvenOddTree(root));
    }
}




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