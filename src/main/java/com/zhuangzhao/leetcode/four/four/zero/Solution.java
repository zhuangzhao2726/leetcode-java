package com.zhuangzhao.leetcode.four.four.zero;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findKthNumber(int n, int k) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        list.sort(String::compareTo);
        return Integer.valueOf(list.get(k - 1));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(13, 2));
    }
}