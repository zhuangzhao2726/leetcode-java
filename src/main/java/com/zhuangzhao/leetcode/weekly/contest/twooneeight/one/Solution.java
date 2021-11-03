package com.zhuangzhao.leetcode.weekly.contest.twooneeight.one;

class Solution {

    public String interpret(String command) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < command.length(); ) {
            if (command.startsWith("G", i)) {
                buffer.append("G");
                i += 1;
                continue;
            }
            if (command.startsWith("()", i)) {
                buffer.append("o");
                i += 2;
                continue;
            }
            if (command.startsWith("(al)", i)) {
                buffer.append("al");
                i += 4;
                continue;
            }

        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.interpret("(al)G(al)()()G"));
    }
}