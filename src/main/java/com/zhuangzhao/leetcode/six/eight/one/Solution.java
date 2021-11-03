package com.zhuangzhao.leetcode.six.eight.one;

import java.util.HashMap;

class Solution extends HashMap {

    public static void main(String[] args) {
        System.out.println(Solution.tableSizeFor(133));
    }


    static final int MAXIMUM_CAPACITY = 1 << 30;


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}