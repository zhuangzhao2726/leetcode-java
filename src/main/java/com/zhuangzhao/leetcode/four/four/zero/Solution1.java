package com.zhuangzhao.leetcode.four.four.zero;

class Solution1 {
    public int findKthNumber(int n, int k) {
        long prefix = 1;
        long cursor = 1;
        while (cursor < k) {
            long count = this.getCount(prefix, n);
            if (cursor + count <= k) {
                prefix++;
                cursor += count;
            } else {
                prefix *= 10;
                cursor++;
            }
        }
        return (int) prefix;
    }

    private long getCount(long prefix, int n) {
        long total = 0L;
        long next = prefix + 1;
        while (prefix <= n) {
            total += Math.min(next - prefix, n - prefix + 1);
            prefix *= 10;
            next *= 10;
        }
        return total;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.findKthNumber(681692778, 351251360));
    }
}