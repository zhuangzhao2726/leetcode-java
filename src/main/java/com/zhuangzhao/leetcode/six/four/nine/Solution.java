package com.zhuangzhao.leetcode.six.four.nine;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }
        int n = senate.length();
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            Integer radiantIndex = radiantQueue.poll();
            Integer direIndex = direQueue.poll();
            if (radiantIndex < direIndex) {
                radiantQueue.offer(radiantIndex + n);
            } else {
                direQueue.offer(direIndex + n);
            }
        }
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.predictPartyVictory("RD"));
    }
}