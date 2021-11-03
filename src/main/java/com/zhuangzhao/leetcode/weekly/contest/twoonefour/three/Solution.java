package com.zhuangzhao.leetcode.weekly.contest.twoonefour.three;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {


    public static long MAX_VALUE = (int) Math.pow(10, 9) + 7;

    public int maxProfit(int[] inventory, int orders) {
        List<Integer> counts = new ArrayList<>(inventory.length);
        for (int i = 0; i < inventory.length; i++) {
            counts.add(inventory[i]);
        }
        counts.sort(Comparator.comparingInt(a -> -a));

        long total = 0;
        while (orders > 0) {
            int left = counts.get(0);
            int right = 0;
            int index = counts.lastIndexOf(counts.get(0));
            if (index + 1 < counts.size()) {
                right = counts.get(index + 1);
            }
            if ((left - right) * (index + 1) <= orders) {
                for (int i = 0; i <= index; i++) {
                    counts.set(i, right);
                }
                total = total + ((long) left + right + 1) * (long) (left - right) * (index + 1) / 2;
                total %= MAX_VALUE;
                orders -= (left - right) * (index + 1);
            } else {
                for (int i = left; i > right; i--) {
                    for (int j = 0; orders > 0 && j <= index; j++) {
                        total += i;
                        total %= MAX_VALUE;
                        orders--;
                    }
                    if (orders <= 0) {
                        break;
                    }
                }
            }
        }
        return (int) total;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inventory = {773160767};
        int orders = 252264991;
        System.out.println(solution.maxProfit(inventory, orders));
    }
}