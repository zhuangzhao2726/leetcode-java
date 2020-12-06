package com.zhuangzhao.leetcode.weekly.contest.twooneone.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        if (threshold == 0 || threshold == 1) {
            for (int[] nums : queries) {
                result.add(true);
            }
            return result;
        }
        if (threshold >= n /2) {
            for (int[] nums : queries) {
                result.add(false);
            }
            return result;
        }


        boolean[][] map = new boolean[n][n];


        Map<Integer, Set<Integer>> yinziMap = new HashMap<>();

        for (int i = threshold + 1; i <= n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j <= i; j++) {
                if (i % j == 0) {
                    set.add(j);
                }
            }
            yinziMap.put(i, set);
        }


        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    map[i][j] = true;
                } else {
                    if (canReach(yinziMap, i + 1, j + 1, threshold)) {
                        map[i][j] = true;
                        map[j][i] = true;
                    }
                }
            }
        }
        for (int[] nums : queries) {
            boolean flag = this.search(map, nums[0] - 1, nums[1] - 1);
            result.add(flag);
        }
        return result;
    }

    private boolean search(boolean[][] map, int a, int b) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        list.add(a);
        set.add(a);
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i);
            for (int j = 0; j < map[index].length; j++) {
                if (map[index][j]) {
                    if (j == b) {
                        return true;
                    } else if (!set.contains(j)) {
                        list.add(j);
                        set.add(j);
                        map[a][j] = true;
                    }
                }
            }
        }
        return false;
    }

    private boolean canReach(Map<Integer, Set<Integer>> yinziMap, int a, int b, int threshold) {
       Set set1 = yinziMap.getOrDefault(a, new HashSet<>());
       Set set2 = yinziMap.getOrDefault(b, new HashSet<>());
       Set result = new HashSet();
       result.addAll(set1);
       result.retainAll(set2);
       return !result.isEmpty();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries = {
                {1,4},{2,5},{3,6}};
        List<Boolean> list = solution.areConnected(8644, 3456, queries);
        for (boolean flag : list) {
            System.out.println(flag);
        }
    }
}