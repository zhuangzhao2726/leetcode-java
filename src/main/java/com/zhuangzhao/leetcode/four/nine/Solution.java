package com.zhuangzhao.leetcode.four.nine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String value : strs) {
            String key =  generateKey(value);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(value);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public String generateKey(String value) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            characters.add(value.charAt(i));
        }
        characters.sort(Comparator.comparingInt(o -> o));
        StringBuilder builder = new StringBuilder();
        for (Character character : characters) {
            builder.append(character);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("---------------");
        }
    }
}