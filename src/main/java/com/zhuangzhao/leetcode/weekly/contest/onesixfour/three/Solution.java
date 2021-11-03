package com.zhuangzhao.leetcode.weekly.contest.onesixfour.three;

import java.util.*;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<String> productList = new ArrayList<>();

        for (String product : products) {
            productList.add(product);
        }
        Collections.sort(productList);


        List<List<String>> result = new ArrayList<>();
        for (int index = 0; index < searchWord.length(); index++) {
            List<String> list = new ArrayList<>();
            String keyword = searchWord.substring(0, index + 1);
            if (!productList.isEmpty()) {
                Iterator<String> iterator = productList.iterator();
                while (iterator.hasNext() && list.size() < 3) {
                    String next = iterator.next();
                    if (next.startsWith(keyword)) {
                        list.add(next);
                    } else {
                        iterator.remove();
                    }
                }
            }
            result.add(list);
        }

        return result;
    }


    public static void main(String[] args) {
        String[] sortStr = new String[]{"CD", "BD", "AD"};
        Arrays.sort(sortStr);
        for (int i = 0; i < sortStr.length; ++i) {
            System.out.println(sortStr[i] + ' ');
        }


        List<String> list = new ArrayList<>();
        list.add("CD");
        list.add("BD");
        list.add("AD");

        Collections.sort(list);
        System.out.println(list);

        System.out.println();

        Solution solution = new Solution();

        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

        List<List<String>> result = solution.suggestedProducts(products, searchWord);

        for (List<String> list1 : result) {
            System.out.println(list1);
        }

        System.out.println();


        String[] products2 = {"havana"};
        searchWord = "havana";


        result = solution.suggestedProducts(products2, searchWord);

        for (List<String> list1 : result) {
            System.out.println(list1);
        }

        System.out.println();

        String[] products3 = {"bags", "baggage", "banner", "box", "cloths"};
        searchWord = "bags";


        result = solution.suggestedProducts(products3, searchWord);

        for (List<String> list1 : result) {
            System.out.println(list1);
        }


        System.out.println();

        String[] products4 = {"havana"};
        searchWord = "tatiana";


        result = solution.suggestedProducts(products4, searchWord);

        for (List<String> list1 : result) {
            System.out.println(list1);
        }
    }
}