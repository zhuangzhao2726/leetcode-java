package com.zhuangzhao.leetcode.lixi.demo03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-05-02 11:19
 */
public class Solution {


    private Map<Product, Integer> total(List<Product> products, int[] counts){
        Map<Product, Integer> result = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            if (result.containsKey(products.get(i))) {
                result.put(products.get(i), result.get(products.get(i) ) + counts[i]);
            } else {
                result.put(products.get(i), counts[i]);
            }
        }
        return result;
    }


    private Map<String, Integer> count(String[] names, int[] counts) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            result.put(names[i], result.getOrDefault(names[i], 0) + counts[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] names = {"A", "A", "B", "B", "C"};
        int[] counts = {1,2,3,4,5};
        Map<String, Integer> result = solution.count(names, counts);
        System.out.println(result.size());
        System.out.println(result);


        List<Product> products = new ArrayList<>();
        products.add(new Product("A", "1"));
        products.add(new Product("A", "1"));
        products.add(new Product("A", "2"));
        products.add(new Product("B", "1"));
        products.add(new Product("B", "1"));
        products.add(new Product("B", "2"));
        products.add(new Product("C", "1"));

        int[] nums = {1,2,3,4,5,6,7};
        Map<Product, Integer> total = solution.total(products, nums);
        System.out.println(total.size());
        System.out.println(total);

    }
}



