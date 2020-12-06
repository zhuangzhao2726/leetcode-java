package com.zhuangzhao.leetcode.two.one.five;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        for (int i = (nums.length - 2)/2; i >= 0; i--) {
            this.adjust(nums, i, nums.length);
        }
        for (int i = 1; i < k; i++) {
            int t = nums[nums.length - i];
            nums[nums.length - i] = nums[0];
            nums[0] = t;
            this.adjust(nums, 0, nums.length - i);
        }
        return nums[0];
    }

    private void adjust(int[] nums, int index, int length) {
        while (index * 2 + 1 < length) {
            int maxIndex = index;
            if (nums[index * 2 + 1] > nums[maxIndex]) {
                maxIndex = index * 2 + 1;
            }
            if (index * 2 + 2 < length && nums[index * 2 + 2] > nums[maxIndex]) {
                maxIndex = index * 2 + 2;
            }
            if (maxIndex != index) {
                int t = nums[index];
                nums[index] = nums[maxIndex];
                nums[maxIndex] = t;
                index = maxIndex;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(nums, 2));


        int[] nums1 = {3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums1, 4));
    }
}