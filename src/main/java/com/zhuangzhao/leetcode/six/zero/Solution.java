package com.zhuangzhao.leetcode.six.zero;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1)
                num[i] = 0;
            else if (i == n - 2)
                num[i] = 1;
            else
                num[i] = num[i + 1] * (n - 1 - i);
        }

        short[] value = new short[n];
        for (int i = 0; i < n - 1; i++) {
            if (k == 0) {
                value[i] = (short) (n  - i);
            } else {
                if (k % num[i] == 0) {
                    value[i] = (short) (k / num[i]);
                } else {
                    value[i] = (short) (1 + k / num[i]);
                }
                k = k % num[i];
            }
        }
        value[n - 1] = 1;
        StringBuffer buffer = new StringBuffer();
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            int j = 0;
            while (count < value[i]) {
                if (!used[j]) {
                    count++;
                    j++;
                } else {
                    j++;
                }
            }
            used[j-1] = true;
            buffer.append(j);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 2));
    }
}