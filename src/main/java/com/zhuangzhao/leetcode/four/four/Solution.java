package com.zhuangzhao.leetcode.four.four;

class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals("")) {
            if (p.equals("")) {
                return true;
            } else if (p.length() >= 1 && p.charAt(0) == '*') {
                return isMatch(s, p.substring(1));
            } else {
                return false;
            }
        } else {
            if (p.equals("")) {
                return false;
            } else {
                if (s.charAt(0) == p.charAt(0)) {
                    return isMatch(s.substring(1), p.substring(1));
                } else if (p.charAt(0) == '?') {
                    return isMatch(s.substring(1), p.substring(1));
                } else if (p.length() >= 2 && p.charAt(0) == '*' && p.charAt(1) == '*') {
                    return isMatch(s, p.substring(1));
                } else if (p.charAt(0) == '*') {
                    return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
                } else {
                    return false;
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
}