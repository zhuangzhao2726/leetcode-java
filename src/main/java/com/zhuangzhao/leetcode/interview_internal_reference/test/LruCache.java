package com.zhuangzhao.leetcode.interview_internal_reference.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-11-10 11:25
 */
public class LruCache<K,V> extends LinkedHashMap<K,V> {

    int capacity;

    public LruCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > capacity;
    }


    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.put("1", "1");
        System.out.println("3" + " --> " + lruCache.get("3"));
        System.out.println("2" + " --> " + lruCache.get("2"));
        System.out.println("1" + " --> " + lruCache.get("1"));
        lruCache.put("2", "2");
        System.out.println("3" + " --> " + lruCache.get("3"));
        System.out.println("2" + " --> " + lruCache.get("2"));
        System.out.println("1" + " --> " + lruCache.get("1"));
        lruCache.put("3", "3");
        System.out.println("3" + " --> " + lruCache.get("3"));
        System.out.println("2" + " --> " + lruCache.get("2"));
        System.out.println("1" + " --> " + lruCache.get("1"));
        lruCache.put("1", "1");
        System.out.println("3" + " --> " + lruCache.get("3"));
        System.out.println("2" + " --> " + lruCache.get("2"));
        System.out.println("1" + " --> " + lruCache.get("1"));

    }
}