package com.zhuangzhao.leetcode.lixi.doublePointerTwo;

public class SolutionTwo {
    public int[] twoSum(int[] numbers, int target) {
    //遍历
        int resultArr[] = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    resultArr = new int[]{i + 1, j + 1};
                    return resultArr;
                }
            }
        }
        return resultArr;
    }
    //双指针
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
