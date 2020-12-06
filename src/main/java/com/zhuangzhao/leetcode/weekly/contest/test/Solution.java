package com.zhuangzhao.leetcode.weekly.contest.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public Double minPrice(String[] books) {
        Map<String, Integer> bookMap = new HashMap<>();
        for (String book : books) {
            bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);
        }
        List<Integer> nums = new ArrayList<>(bookMap.values());
        double[] discount = {1.0, 0.95, 0.90, 0.80, 0.75};
        double price = 8.0;
        double total = 0.0;
        while (true) {
            int count = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) > 0) {
                    count++;
                    nums.set(i, nums.get(i) -  1);
                }
            }
            if (count == 0) {
                break;
            } else {
                total += price * count * discount[count - 1];
            }
        }
        return total;
    }




    public void printZhifangtu(String[] metries, int[] value) {
        int max = 0;
        int min = 0;
        for (int i = 0;  i < value.length; i++) {
            if (max < value[i]) {
                max = value[i];
            }
            if (min > value[i]) {
                min = value[i];
            }
        }

        for (int j = max; j > 0; j--) {
            System.out.print("|");
            for (int i = 0; i < value.length; i++) {
                 if (j <= value[i]) {
                     System.out.print(" *");
                 } else {
                     System.out.print("  ");
                 }
             }
            System.out.println();
        }
        for (int i = 0; i <= metries.length; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int j = -1; j >= min; j--) {
            System.out.print("|");
            for (int i = 0; i < value.length; i++) {
                if (j >= value[i]) {
                    System.out.print(" *");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

//        System.out.println();
//        System.out.print("  ");
//        for (int i = 0; i < metries.length; i++) {
//            System.out.print(metries[i] + " ");
//        }
    }




    public static void main(String[] args) {
       Solution solution = new Solution();
        String[] metries = {"a", "b", "c"};
        int[] value  = {3, -5, 7};
        solution.printZhifangtu(metries, value);
    }
}