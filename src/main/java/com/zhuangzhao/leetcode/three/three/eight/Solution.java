package com.zhuangzhao.leetcode.three.three.eight;

class Solution {
//    public int[] countBits(int num) {
//        int[] result = new int[num + 1];
//        for (int i = 0; i <= num; i++) {
//            int count = 0;
//            int value = i;
//            while (value > 0) {
//                if ((value & 1) == 1) {
//                    count++;
//                }
//                value >>= 1;
//            }
//            result[i] = count;
//        }
//        return result;
//    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + i & 1;
        }
        return result;
    }
}