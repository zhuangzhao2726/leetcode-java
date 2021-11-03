package com.zhuangzhao.leetcode.weekly.contest.fivefourzero.three;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            index.add(0);
        }
        List<List<Integer>> indexList = new ArrayList<>();
        int count = 1;
        indexList.add(index);
        while (true) {
            if (count == k) {
                int total = 0;
                for (int j = 0; j < m; j++) {
                    total += mat[j][index.get(j)];
                }
                return total;
            } else {

            }
        }

    }


    private boolean isContain(List<List<Integer>> indexList, List<Integer> list) {
        for (List<Integer> index : indexList) {
            int i = 0;
            for (i = 0; i < index.size(); i++) {
                if (!index.get(i).equals(list.get(i))) {
                    break;
                }
            }
            if (i == index.size()) {
                return false;
            }
        }
        return true;
    }
}