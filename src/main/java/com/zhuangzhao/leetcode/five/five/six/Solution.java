package com.zhuangzhao.leetcode.five.five.six;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> nums = new ArrayList<>();
        int x =n;
        int min = -1;
        int value = -1;
        while (x > 0) {
            int y = x % 10;
            x = x / 10;
            if (min == -1) {
                min = y;
                nums.add(y);
            } else if (y >= min) {
                min = y;
                nums.add(y);
            } else {
                nums.add(y);
                value = y;
                break;
            }
        }
        if (value == -1) {
            return -1;
        }
        nums.sort(Comparator.comparingInt(a -> a));
        long y = x;
        for (Integer val : nums) {
            if (val > value) {
                y = y * 10 + val;
                nums.remove(val);
                break;
            }
        }
        for (Integer val : nums) {
            y = y * 10 + val;
        }
        if (y > (2L << 30 -1)) {
            return -1;
        }
        return (int) y;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(2147483486));
    }
}