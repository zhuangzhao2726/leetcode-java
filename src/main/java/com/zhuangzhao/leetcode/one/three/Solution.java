package com.zhuangzhao.leetcode.one.three;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static Map<String, Integer>  map = new HashMap<>();
    static {
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
        map.put("CM", 900);
        map.put("CD", 400);
        map.put("XC", 90);
        map.put("XL", 40);
        map.put("IX", 9);
        map.put("IV", 4);
    }
    public int romanToInt(String s) {

        int value = 0;
        for (int i = 0; i < s.length();) {
            if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
                value += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                value += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return value;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }




}