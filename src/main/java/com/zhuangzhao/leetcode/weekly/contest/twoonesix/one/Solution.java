package com.zhuangzhao.leetcode.weekly.contest.twoonesix.one;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return this.arrayToString(word1).equalsIgnoreCase(this.arrayToString(word2));
    }

    private String arrayToString(String[] words) {
        StringBuffer buffer = new StringBuffer("");
        for (String word : words) {
            buffer.append(word);
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        String[] word1 = {"a", "bc"};
        String[] word2 = {"ab", "c"};
        Solution solution = new Solution();
        System.out.println(solution.arrayStringsAreEqual(word1, word2));
    }
}