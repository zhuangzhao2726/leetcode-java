package com.zhuangzhao.leetcode.one.eight.douyin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        HashMap<Integer, Integer> stapleMap = this.count(staple);
        HashMap<Integer, Integer> drinksMap = this.count(drinks);
        List<Integer> stapleList = new ArrayList<>(stapleMap.keySet());
        List<Integer> drinksList = new ArrayList<>(drinksMap.keySet());
        stapleList.sort(Comparator.comparingInt(a -> a));
        drinksList.sort(Comparator.comparingInt(a -> a));
        long total = 0;
        int i = 0;
        int j = drinksList.size() - 1;
        int num = drinks.length;
        while (i < stapleList.size() && j >= 0) {
            if (stapleList.get(i) + drinksList.get(j) <= x) {
                total += num * stapleMap.get(stapleList.get(i));
                i++;
            } else {
                num -= drinksMap.get(drinksList.get(j));
                j--;
            }
        }
        total = total % 1000000007;
        return (int) total;
    }

    private HashMap<Integer, Integer> count(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] staple = {10,20,5};
        int[] drinks = {5,5,2};
        int x = 15;
        System.out.println(solution.breakfastNumber( drinks, staple, x));
    }
}