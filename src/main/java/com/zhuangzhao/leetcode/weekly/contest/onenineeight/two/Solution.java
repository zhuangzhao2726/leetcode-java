package com.zhuangzhao.leetcode.weekly.contest.onenineeight.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {

        int[] result =  new int[n];
        Map<Integer, List<Integer>> treeMap = new HashMap<>();
        createTreeMap(edges, treeMap, 0);
        TreeNode[]  treeNodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            TreeNode treeNode = getTreeNode(treeMap, treeNodes, labels, i);
            result[i] = treeNode.count;
        }
        return result;
    }

    private TreeNode getTreeNode(Map<Integer, List<Integer>> treeMap, TreeNode[] treeNodes, String labels, int i) {
        if (treeNodes[i] == null) {
            List<Integer> sonNodeList = treeMap.get(i);

            Map<Character, Integer> charMap = new HashMap<>();
            charMap.put(labels.charAt(i), 1);
            if (sonNodeList != null && sonNodeList.size() > 0) {
                for (Integer index : sonNodeList) {
                    TreeNode sonNode = getTreeNode(treeMap, treeNodes, labels, index);
                    sonNode.charMap.entrySet().forEach( entry -> {
                        Character key = entry.getKey();
                        if (charMap.containsKey(key)) {
                            charMap.put(key, charMap.get(key) + entry.getValue());
                        } else {
                            charMap.put(key, entry.getValue());
                        }
                    });
                }
            }
            TreeNode treeNode = new TreeNode();
            treeNode.value = labels.charAt(i);
            treeNode.charMap = charMap;
            treeNode.count = charMap.get(treeNode.value);
            treeNodes[i] = treeNode;
        }
        return  treeNodes[i];
    }

    private void createTreeMap(int[][] edges, Map<Integer, List<Integer>> treeMap, int index) {
        if (!treeMap.containsKey(index)) {
            List<Integer> sonNode = new ArrayList<>();
            for (int[] edge : edges) {
                if (edge[0] == index && !treeMap.containsKey(edge[1])) {
                    sonNode.add(edge[1]);
                } else if (edge[1] == index && !treeMap.containsKey(edge[0])) {
                    sonNode.add(edge[0]);
                }
            }
            treeMap.put(index, sonNode);
            for (Integer i : sonNode) {
                createTreeMap(edges, treeMap, i);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 100000;
        int[][] edges  =  {{}};
        StringBuilder builder = new StringBuilder("");
        int[] result = solution.countSubTrees(n, edges, builder.toString());
        for (int value : result) {
            System.out.print(value + "  ");
        }
        System.out.println();
    }
}



class TreeNode {
    Character value;
    int count;
    Map<Character,Integer> charMap;
}