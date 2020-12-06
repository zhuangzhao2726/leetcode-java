package com.zhuangzhao.leetcode.weekly.contest.twoonefour.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> counts = new ArrayList<>(map.values());
        Set<Integer> result = new HashSet<>();
        int total = 0;
        for (int count : counts) {
            total += this.count(result, count);
        }
        return total;
    }

    private int count(Set<Integer> result, int count) {
        int total = 0;
        while (count > 0 && result.contains(count)) {
            total++;
            count--;
        }
        if (count > 0) {
            result.add(count);
        }
        return total;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDeletions("aab"));
        System.out.println(solution.minDeletions("aaabbbcc"));
        System.out.println(solution.minDeletions("ceabaacb"));
        System.out.println(solution.minDeletions("aab"));
    }
}