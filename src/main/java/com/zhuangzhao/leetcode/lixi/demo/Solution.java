package com.zhuangzhao.leetcode.lixi.demo;

class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstNum = transNum(firstWord);
        int secondNum = transNum(secondWord);
        int targetNum = transNum(targetWord);
        if (firstNum + secondNum == targetNum) {
            return true;
        } else {
            return false;
        }

    }

    public int transNum(String str) {
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            number = number * 10 + str.charAt(i) - 'a';
        }
        return number;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Boolean flag = s.isSumEqual("acb","cba","cdb");
        System.out.println(flag);
    }
}