package com.zhuangzhao.leetcode.lixi.bsweek02;

import java.util.*;

class Solution {
    public int reductionOperations(int[] nums) {
        //1、统计数组每个数字出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
       //2、拿到key做倒序
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> o2-o1);

        int total = 0;
        for (int i = 0;i<list.size()-1;i++) {
            total += map.get(list.get(i));
            map.put(list.get(i + 1), map.get(list.get(i + 1)) + map.get(list.get(i)));
        }
        return total;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5};
        int temp = solution.reductionOperations(nums);
        System.out.println(temp);

    }
}