package com.zhuangzhao.leetcode.lixi.doublePointer;

import java.util.Arrays;

class Solution {
//    //直接排序
//    public int[] sortedSquares(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(nums);
//        return nums;
//    }

//    //双指针1
//    public int [] sortedSquares(int[] nums){
//        int n = nums.length;
//        int[] ans = new int[n];
//        int lpointer = -1;
//        //双指针：第一步：找到递增或者递减的指针位置
//        for(int i = 0;i<nums.length;i++){
//            if(nums[i]<0){
//                lpointer = i;
//            }else{
//                break;
//            }
//        }
//
//        //双指针：第二步：利用类似归并排序进行对其数组元素的平方排序
//        int i = lpointer; int j = lpointer+1; int index= 0;
//        while(i>=0||j<n){
//            if(i<0){
//                ans[index] = nums[j]*nums[j];
//                j++;
//            }else if(j==n){
//                ans[index] = nums[i]*nums[i];
//                i--;
//            }else if(nums[i]*nums[i]<=nums[j]*nums[j]){
//                ans[index] = nums[i]*nums[i];
//                i--;
//            }else if(nums[i]*nums[i]>nums[j]*nums[j]){
//                ans[index]= nums[j]*nums[j];
//                j++;
//            }
//            index++;
//        }
//    return ans;
//
//    }
    //双指针2

//    同样地，我们可以使用两个指针分别指向位置 0 和 n-1，
//    每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。
//    这种方法无需处理某一指针移动至边界的情况，读者可以仔细思考其精髓所在。
public int [] sortedSquares(int[] nums){
    int n = nums.length;
    int [] ans = new int[n];
    for(int i = 0,j=n-1,pos = n-1;i<=j;){
        if(nums[i]*nums[i]<=nums[j]*nums[j]){
            ans[pos] = nums[j]*nums[j];
            j--;
        }else {
            ans[pos] = nums[i]*nums[i];
            i++;
        }
    }
    return ans;
}



}