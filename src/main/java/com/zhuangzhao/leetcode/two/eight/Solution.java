package com.zhuangzhao.leetcode.two.eight;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int strStr(String haystack, String needle) {
        List<Integer> next = calcNextList(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next.get(j);
            }
        }
        if (j == needle.length()) {
            return i -  j;
        }
        return -1;
    }

    private List<Integer> calcNextList(String needle) {
        List<Integer> list = new ArrayList<>(needle.length());
        int k = -1;
        int j = 0;
        list.add(k);
        while (j < needle.length()) {
            if (k < 0 || needle.charAt(j) == needle.charAt(k)) {
                list.add(++k);
                j++;
            } else {
                k = list.get(k);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.strStr("hello", "ll"));
//        System.out.println(solution.strStr("aaaaa", "bba"));
//        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("mississippi","issip"));
    }
}