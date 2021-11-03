package com.zhuangzhao.leetcode.weekly.contest.twooneone.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        list.add(s);
        set.add(s);
        for (int i = 0; i < list.size(); i++) {
            String s1 = this.operate1(list.get(i), a);
            if (!set.contains(s1)) {
                list.add(s1);
                set.add(s1);
            }
            String s2 = this.operate2(list.get(i), b);
            if (!set.contains(s2)) {
                list.add(s2);
                set.add(s2);
            }
        }
        list.sort(String::compareTo);
        return list.get(0);
    }

    private String operate1(String s, int a) {
        StringBuffer buffer = new StringBuffer(s);
        for (int i = 1; i < s.length(); i += 2) {
            buffer.setCharAt(i, (char) ('0' + (s.charAt(i) - '0' + a) % 10));
        }
        return buffer.toString();
    }

    private String operate2(String s, int b) {
        b = b % s.length();
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLexSmallestString("0828265976149473834240719308951729926225100715191213267697293340972124", 1, 19));
    }
}