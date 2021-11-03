package com.zhuangzhao.leetcode.weekly.contest.twofourthree.one;

class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = transfer2int(firstWord);
        int second = transfer2int(secondWord);
        int target = transfer2int(targetWord);
        return first + second == target;
    }


    private int transfer2int(String word) {
        int num = 0;
        for (int i = 0; i < word.length(); i++) {
            num = num * 10 + word.charAt(i) - 'a';
        }
        return num;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();

     //   System.out.println(solution.isSumEqual("acb", "cba","cdb"));
     //   System.out.println(solution.isSumEqual("aaa", "a","aab"));
    //    System.out.println(solution.isSumEqual("aaa", "a","aaaa"));
        System.out.println(solution.isSumEqual("j", "j","bi"));
    }
}