package com.zhuangzhao.leetcode.five;


/**
 * f(i,j) = f(i+1,j-1) && (s(i) == s(j))
 */
class Solution {
    public String longestPalindrome(String s) {

        // 字符串长度
        int length = s.length();

        // 长度为一的是回文串
        boolean[][] map = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            map[i][i] = true;
        }
        // 判断成都为2的回文串
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                map[i][i + 1] = true;
            }
        }
        //  f(i,j) = f(i+1,j-1) && (s(i) == s(j))
        for (int i = 2; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (map[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i)) {
                    map[j][j + i] = true;
                } else {
                    map[j][j + i] = false;
                }
            }
        }

        // 找最长的回文串
        int max = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = i; j < length; j++) {
                if (map[i][j]) {
                    count = j - i + 1;
                }
            }
            if (count > max) {
                max = count;
                index = i;
            }
        }

        return s.substring(index, index + max);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*System.out.println("1234567890 : " + solution.longestPalindrome("1234567890"));
        System.out.println("1234567890987654321 : " + solution.longestPalindrome("1234567890987654321"));
        System.out.println("qwertyuiopoiuytrewq : " + solution.longestPalindrome("qwertyuiopoiuytrewq"));
        System.out.println("wertghjkluoiyutyftdf : " + solution.longestPalindrome("wertghjkluoiyutyftdf"));
        System.out.println("srfgchdyrtewradsfdfxdr : " + solution.longestPalindrome("srfgchdyrtewradsfdfxdr"));
        System.out.println("utyuftdhf : " + solution.longestPalindrome("utyuftdhf"));
        System.out.println("gfhtdrsgfbfdrt : " + solution.longestPalindrome("gfhtdrsgfbfdrt"));*/
        System.out.println("ccc : " + solution.longestPalindrome("ccc"));
    }
}