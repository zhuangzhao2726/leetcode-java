package com.zhuangzhao.leetcode.weekly.contest.onesixnine.two;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {


        List<Integer> list01 = new ArrayList<>();
        visit(root1, list01);

        List<Integer> list02 = new ArrayList<>();
        visit(root2, list02);


        return merge(list01, list02);

    }

    private List<Integer> merge(List<Integer> list01, List<Integer> list02) {
        List<Integer> list = new ArrayList<>(list01);
        list.addAll(list02);
        Collections.sort(list);
        return list;
    }

    private void visit(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                visit(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                visit(root.right, list);
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        list2.add(3);
        list2.add(2);


        Solution solution = new Solution();

        System.out.println(solution.merge(list, list2));

    }
}