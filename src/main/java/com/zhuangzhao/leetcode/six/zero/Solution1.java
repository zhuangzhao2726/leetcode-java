package com.zhuangzhao.leetcode.six.zero;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-10-17 23:03
 */
class Solution1 {
    public String getPermutation(int n, int k) {
        List<String> result = this.search(new int[n], new boolean[n], n, 0, k);
        return k <= result.size() ? result.get(k - 1) : "";
    }


    private List<String> search(int[] nums, boolean[] used, int n, int index, int k) {
        List<String> result = new ArrayList<>();
        if (index == n) {
            result.add(this.array2String(nums));
            return result;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                nums[index] = i + 1;
                result.addAll(this.search(nums, used, n, index + 1, k));
                used[i] = false;
                if (result.size() >= k) {
                    break;
                }
            }
        }
        return result;
    }

    private String array2String(int[] nums) {
        StringBuffer buffer = new StringBuffer();
        for (int num : nums) {
            buffer.append(num);
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getPermutation(9, 214267));
    }
}