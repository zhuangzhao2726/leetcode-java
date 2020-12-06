package com.zhuangzhao.leetcode.weekly.contest.onesixfour.four;

import java.util.HashMap;
import java.util.Map;

class Solution {


    private Map<String, Integer>  numWaysMap;

    private String keyPattern = "%s.%s";

    public int numWays(int steps, int arrLen) {

        numWaysMap =  new HashMap<>();
        int total = dp(0, steps, arrLen);
        return total;
    }


    private int dp(int pos, int step, int length) {

        if(step == 0) {
            return pos == 0 ? 1 : 0;
        }

        String key = pos + "," + step;

        if (numWaysMap.containsKey(key)) {
            return numWaysMap.get(key);
        }

        int total = 0;
        total += dp(pos, step - 1, length);
        if(pos > 0) {
            total += dp(pos - 1, step - 1, length);
        }
        if (pos < length - 1) {
            total += dp(pos + 1, step - 1, length);
        }
        total %= (10^9 + 7);
        numWaysMap.put(key, total);
        return total;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Solution solution = new Solution();


        for (int i = 0; i < 1000000; i++) {
            String key = String.format(solution.keyPattern, 10, 1000);
        }
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            String key = 10 + "," + 1000;
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}