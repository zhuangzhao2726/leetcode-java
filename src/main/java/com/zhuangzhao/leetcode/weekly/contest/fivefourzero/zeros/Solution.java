package com.zhuangzhao.leetcode.weekly.contest.fivefourzero.zeros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        String start = paths.get(0).get(0);
        String end = "";
        while (map.containsKey(start)) {
            end = map.get(start);
            start = end;
        }
        return end;
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();


        List<String> path01 = new ArrayList<>();
        path01.add("London");
        path01.add("New York");
        paths.add(path01);

        List<String> path02 = new ArrayList<>();
        path02.add("New York");
        path02.add("Lima");
        paths.add(path02);

        List<String> path03 = new ArrayList<>();
        path03.add("Lima");
        path03.add("Sao Paulo");
        paths.add(path03);

        Solution solution = new Solution();
        System.out.println(solution.destCity(paths));
    }
}