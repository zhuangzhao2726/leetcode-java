package com.zhuangzhao.leetcode.three;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> charMap = new HashMap<Character, Integer>(128);

        int start = 0;
        int length = 0;
        char c;

        int max = s.length() > 0 ? 1 : 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!charMap.containsKey(c)) {
                charMap.put(c, i);
                length = i - start + 1;
                if (length > max) {
                    max = length;
                }
            } else if (charMap.get(c) < start) {
                charMap.put(c, i);
                length = i - start + 1;
                if (length > max) {
                    max = length;
                }
            } else {
                start = charMap.get(c) + 1;
                charMap.put(c, i);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(length);
    }
}