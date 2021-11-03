package com.zhuangzhao.leetcode.weekly.contest.twoonefive.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderedStream {

    int ptr;

    Map<Integer, String> map;


    public OrderedStream(int n) {
        this.ptr = 1;
        this.map = new HashMap<>();

    }

    public List<String> insert(int id, String value) {
        map.put(id, value);
        List<String> result = new ArrayList<>();
        while (map.containsKey(ptr)) {
            result.add(map.get(ptr));
            ptr++;
        }
        return result;
    }
}