package com.zhuangzhao.leetcode.weekly.contest.twoonefive.two;

import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] word1CharCount = this.countChar(word1);
        int[] word2CharCount = this.countChar(word2);

        for (int i = 0; i < word1CharCount.length; i++) {
            if (word1CharCount[i] * word2CharCount[i] == 0 && word1CharCount[i] + word2CharCount[i] > 0) {
                return false;
            }
        }


        word1CharCount = Arrays.stream(word1CharCount).sorted().toArray();
        word2CharCount = Arrays.stream(word2CharCount).sorted().toArray();
        for (int i = 0; i < word1CharCount.length; i++) {
            if (word1CharCount[i] != word2CharCount[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] countChar(String word) {
        int[] charCount = new int[26];
        for (int i = 0; word != null && i < word.length(); i++) {
            charCount[word.charAt(i) - 'a']++;
        }
        return charCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closeStrings("cabbba", "abbccc"));
    }
}