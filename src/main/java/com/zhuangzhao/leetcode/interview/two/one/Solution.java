package com.zhuangzhao.leetcode.interview.two.one;

class Solution {

    public Integer countTripNum(String[][] tickets) {
        int count  = 0;
        String start = null;
        for (String[] ticket : tickets) {
            if (start == null) {
                start = ticket[0];
            }
            if (start.equals(ticket[1])) {
                count++;
                start = null;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String[][] tickets = {{"A", "B"}, {"B", "C"}, {"C", "A"}, {"D","E"}, {"E", "D"}};
        Solution solution = new Solution();
        System.out.println(solution.countTripNum(tickets));
    }
}