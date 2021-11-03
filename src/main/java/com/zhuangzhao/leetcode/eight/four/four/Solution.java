package com.zhuangzhao.leetcode.eight.four.four;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return this.backspace(S).equals(this.backspace(T));
    }

    private String backspace(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '#':
                    if (buffer.length() > 0) {
                        buffer.deleteCharAt(buffer.length() - 1);
                    }
                    break;
                default:
                    buffer.append(s.charAt(i));
            }
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
    }
}