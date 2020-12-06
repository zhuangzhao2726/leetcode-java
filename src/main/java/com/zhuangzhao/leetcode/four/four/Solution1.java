package com.zhuangzhao.leetcode.four.four;

class Solution1 {
    public boolean isMatch(String s, String p) {
        boolean[][] map = new boolean[s.length() + 1][p.length() + 1];
        map[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                map[0][j] = map[0][j - 1];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    map[i][j] = map[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    map[i][j] = map[i][j - 1] | map[i - 1][j];
                }
            }
        }
        return map[s.length()][p.length()];
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
}