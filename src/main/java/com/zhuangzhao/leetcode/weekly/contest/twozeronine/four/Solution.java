package com.zhuangzhao.leetcode.weekly.contest.twozeronine.four;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumOneBitOperations(int n) {
        List<Integer> list = new ArrayList<>(1 << 20);
        List<Integer> steps = new ArrayList<>(1 << 20);
        List<Integer> operates = new ArrayList<>(1 << 20);
        list.add(n);
        steps.add(0);
        operates.add(0);
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            int step = steps.get(i);
            Integer operate = operates.get(i);
            if (value == 0) {
                return step;
            }
            if (operate != 1) {
                int value01 = this.operate01(value);
                if (value01 == 0) {
                    return step + 1;
                } else if (!list.contains(value01)) {
                    list.add(value01);
                    steps.add(step + 1);
                    operates.add(1);
                }
            }
            if (operate != 2) {
                int value02 = this.operate02(value);
                if (value02 == 0) {
                    return step + 1;
                } else if (!list.contains(value02)) {
                    list.add(value02);
                    steps.add(step + 1);
                    operates.add(2);
                }
            }
        }
        return -1;
    }


    public int operate01(int n) {
        return n ^ 1;
    }

    public int operate02(int n) {
        int indexOfZero = -1;
        int value = n;
        while ((value & 1) == 0) {
            value >>= 1;
            indexOfZero++;
        }
        return n ^ (1 << (indexOfZero + 2));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();


//        System.out.println(solution.minimumOneBitOperations(3));
//        System.out.println(solution.minimumOneBitOperations(6));
//        System.out.println(solution.minimumOneBitOperations(9));
        System.out.println(solution.minimumOneBitOperations(11658));
    }
}