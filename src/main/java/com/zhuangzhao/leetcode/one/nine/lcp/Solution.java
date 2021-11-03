package com.zhuangzhao.leetcode.one.nine.lcp;

class Solution {
    public int minimumOperations(String leaves) {
        int[][] f = new int[leaves.length()][3];
        f[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        f[0][1] = Integer.MAX_VALUE;
        f[0][2] = Integer.MAX_VALUE;
        f[1][0] = f[0][0] + (leaves.charAt(1) == 'r' ? 0 : 1);
        f[1][1] = f[0][0] + (leaves.charAt(1) == 'y' ? 0 : 1);
        f[1][2] = Integer.MAX_VALUE;
        for (int i = 2; i < leaves.length(); i++) {
            f[i][0] = f[i - 1][0] + (leaves.charAt(i) == 'r' ? 0 : 1);
            f[i][1] = (Math.min(f[i - 1][0], f[i - 1][1]) + (leaves.charAt(i) == 'y' ? 0 : 1));
            f[i][2] = (Math.min(f[i - 1][1], f[i - 1][2]) + (leaves.charAt(i) == 'r' ? 0 : 1));
        }
        return f[leaves.length() - 1][2];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations("rrryyyrryyyrr"));
    }
}