package com.zhuangzhao.leetcode.interview.ninetwo.two;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-09-02 20:14
 */
public class Solution {

    int maxPrice = 0;

    int[] minPrice;

    public static void main(String[] args) {
        int cap = 9;
        int count = 5;
        int[] weight = {2, 2, 4, 6, 3};
        int[] price = {3, 4, 8, 9, 6};


        Solution solution = new Solution();
        solution.maxPrice = 0;
        solution.minPrice =  new int[count];
        solution.search(weight, price, cap, 0, 0, 0);
        System.out.println(solution.maxPrice);
    }


    public void search(int[] weight, int[] price, int cap, int index, int preWeight, int prePrice) {
        if (index >= weight.length) {
            return;
        }
        if (prePrice < minPrice[index]) {
            return;
        } else if (prePrice > minPrice[index]) {
            minPrice[index] = prePrice;
        }
        search(weight, price, cap, index + 1, preWeight, prePrice);
        if (preWeight + weight[index] <= cap) {
            if (prePrice + price[index] > maxPrice) {
                maxPrice = prePrice + price[index];
            }
            search(weight, price, cap, index + 1, preWeight + weight[index], prePrice + price[index]);
        }
    }
}
